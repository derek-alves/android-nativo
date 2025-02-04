package com.composablecode.core.httpClient

import ApiClient
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
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json


class ApiClientImpl(
    private val client: HttpClient,
    private val json: Json = Json { ignoreUnknownKeys = true }
) : ApiClient {
    override suspend fun <T> request(
        method: HttpMethod,
        url: String,
        serializer: KSerializer<T>,
        headers: MapType,
        body: Any?
    ): Result<T> {
        return try {
            val response = client.request(url) {
                this.method = method
                headers.forEach { (key, value) -> header(key, value) }
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                body?.let { setBody(it) }
            }

            handleResponse(response, serializer)
        } catch (e: Exception) {
            handleException(e)
        }
    }

    private suspend fun <T> handleResponse(
        response: HttpResponse,
        serializer: KSerializer<T>
    ): Result<T> {
        return when (response.status) {
            HttpStatusCode.OK -> {
                val result = json.decodeFromString(serializer, response.bodyAsText())
                Result.success(result)
            }

            HttpStatusCode.BadRequest -> Result.failure(ApiError.BadRequest)
            HttpStatusCode.Unauthorized -> Result.failure(ApiError.Unauthorized)
            HttpStatusCode.Forbidden -> Result.failure(ApiError.Forbidden)
            HttpStatusCode.NotFound -> Result.failure(ApiError.NotFound)
            HttpStatusCode.InternalServerError -> Result.failure(ApiError.InternalServerError)
            HttpStatusCode.ServiceUnavailable -> Result.failure(ApiError.ServiceUnavailable)
            else -> {
                val errorBody = response.bodyAsText()
                Result.failure(ApiError.CustomError(response.status.value, errorBody))
            }
        }

    }

    private fun handleException(e: Exception): Result<Nothing> {
        return when (e) {
            is TimeoutCancellationException -> Result.failure(
                ApiError.Timeout
            )

            is ClientRequestException -> Result.failure(
                ApiError.CustomError(
                    e.response.status.value,
                    e.message ?: ""
                )
            )

            is SerializationException -> Result.failure(
                ApiError.SerializationError
            )

            is IOException -> Result.failure(ApiError.NetWorkError)
            else -> Result.failure(ApiError.Unknown)
        }
    }
}


sealed class ApiError : Exception() {
    data object BadRequest : ApiError()
    data object Unauthorized : ApiError()
    data object Forbidden : ApiError()
    data object NotFound : ApiError()
    data object InternalServerError : ApiError()
    data object ServiceUnavailable : ApiError()
    data object Timeout : ApiError()
    data object Unknown : ApiError()
    data object NetWorkError : ApiError()
    data object SerializationError : ApiError()

    data class CustomError(val statusCode: Int, override val message: String) : ApiError()
}
