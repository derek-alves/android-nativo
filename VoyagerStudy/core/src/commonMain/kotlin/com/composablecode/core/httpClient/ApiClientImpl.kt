package com.composablecode.core.httpClient

import com.composablecode.core.httpClient.utils.MapType
import io.ktor.client.HttpClient
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.io.IOException

class ApiClientImpl(private val client: HttpClient) : ApiClient {
    override suspend fun get(url: String, headers: MapType): Result<String> {
        return makeRequest(HttpMethod.Get, url, headers)
    }

    override suspend fun post(url: String, body: Any?, headers: MapType): Result<String> {
        return makeRequest(HttpMethod.Post, url, headers, body ?: "{}")
    }

    override suspend fun put(url: String, body: Any?, headers: MapType): Result<String> {
        return makeRequest(HttpMethod.Put, url, headers, body ?: "{}")
    }

    override suspend fun delete(url: String, headers: MapType): Result<String> {
        return makeRequest(HttpMethod.Delete, url, headers)
    }

    private suspend inline fun executeRequest(
        request: () -> HttpResponse
    ): Result<String> {
        return try {
            val response = request()


            when (response.status) {
                HttpStatusCode.OK -> Result.Success(response.bodyAsText())
                HttpStatusCode.BadRequest -> Result.Failure(ApiError.BadRequest)
                HttpStatusCode.Unauthorized -> Result.Failure(ApiError.Unauthorized)
                HttpStatusCode.Forbidden -> Result.Failure(ApiError.Forbidden)
                HttpStatusCode.NotFound -> Result.Failure(ApiError.NotFound)
                HttpStatusCode.InternalServerError -> Result.Failure(ApiError.InternalServerError)
                HttpStatusCode.ServiceUnavailable -> Result.Failure(ApiError.ServiceUnavailable)
                else -> {
                    val errorBody = response.bodyAsText()
                    Result.Failure(ApiError.CustomError(response.status.value, errorBody))
                }
            }
        } catch (e: TimeoutCancellationException) {
            Result.Failure(ApiError.Timeout)
        } catch (e: ClientRequestException) {
            Result.Failure(ApiError.CustomError(e.response.status.value, e.message ?: ""))
        } catch (e: IOException) {
            Result.Failure(ApiError.NetWorkError)
        } catch (e: Exception) {
            Result.Failure(ApiError.Unknown)
        }
    }

    private suspend fun makeRequest(
        method: HttpMethod,
        url: String,
        headers: MapType,
        body: Any? = null
    ): Result<String> {
        return executeRequest {
            client.request(url) {
                this.method = method
                headers.forEach { (key, value) -> header(key, value) }
                header(
                    HttpHeaders.ContentType,
                    ContentType.Application.Json
                )
                if (body != null) setBody(body)
            }
        }
    }
}