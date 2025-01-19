package com.composablecode.core.httpClient

interface ApiClient {
    suspend fun get(
        url: String,
        headers: Map<String, String> = emptyMap()
    ): Result<Map<String, String>>

    suspend fun post(
        url: String,
        body: Any? = null,
        headers: Map<String, String> = emptyMap()
    ): Result<Map<String, String>?>

    suspend fun put(
        url: String,
        body: Any? = null,
        headers: Map<String, String> = emptyMap()
    ): Result<Map<String, String>?>

    suspend fun delete(
        url: String,
        headers: Map<String, String> = emptyMap()
    ): Result<Map<String, String>?>
}


sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val error: ApiError) : Result<Nothing>()
}

sealed class ApiError {
    data object BadRequest : ApiError() // 400
    data object Unauthorized : ApiError() // 401
    data object Forbidden : ApiError() // 403
    data object NotFound : ApiError() // 404
    data object InternalServerError : ApiError() // 500
    data object ServiceUnavailable : ApiError() // 503
    data object Timeout : ApiError() // Timeout
    data object Unknown : ApiError() // Qualquer outro erro
    data class CustomError(val statusCode: Int, val message: String) : ApiError()
}