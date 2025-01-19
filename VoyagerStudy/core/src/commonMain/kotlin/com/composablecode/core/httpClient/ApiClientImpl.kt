package com.composablecode.core.httpClient

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.Json

class ApiClientImpl(private val client: HttpClient) : ApiClient {

    override suspend fun get(
        url: String,
        headers: Map<String, String>
    ): Result<Map<String, String>> {
        return executeRequest {
            client.get(url) {
                headers.forEach { (key, value) -> header(key, value) }
            }
        }
    }

    override suspend fun post(
        url: String,
        body: Any?,
        headers: Map<String, String>
    ): Result<Map<String, String>?> {
        return executeRequest {
            client.post(url) {
                headers.forEach { (key, value) -> header(key, value) }
                setBody(body ?: "")
            }
        }
    }

    override suspend fun put(
        url: String,
        body: Any?,
        headers: Map<String, String>
    ): Result<Map<String, String>?> {
        return executeRequest {
            client.put(url) {
                headers.forEach { (key, value) -> header(key, value) }
                setBody(body ?: "")
            }
        }
    }

    override suspend fun delete(
        url: String,
        headers: Map<String, String>
    ): Result<Map<String, String>?> {
        return executeRequest {
            client.delete(url) {
                headers.forEach { (key, value) -> header(key, value) }
            }
        }
    }

    private suspend inline fun executeRequest(
        request: () -> HttpResponse
    ): Result<Map<String, String>> {
        return try {
            val response = request()

            val bodyAsJson = Json.parseToJsonElement(response.bodyAsText())


            // Verificar o status da resposta
            when (response.status) {
                HttpStatusCode.OK -> Result.Success(bodyAsJson)
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
        } catch (e: Exception) {
            // Tratar exceções, como timeouts e erros desconhecidos
            when (e) {
                is io.ktor.client.network.sockets.SocketTimeoutException -> Result.Failure(ApiError.Timeout)
                else -> Result.Failure(ApiError.Unknown)
            }
        }
    }
}