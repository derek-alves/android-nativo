package com.composablecode.core.httpClient

import com.composablecode.core.httpClient.utils.MapType

interface ApiClient {
    suspend fun get(
        url: String,
        headers: MapType = emptyMap()
    ): Result<String>

    suspend fun post(
        url: String,
        body: Any? = null,
        headers: MapType = emptyMap()
    ): Result<String>

    suspend fun put(
        url: String,
        body: Any? = null,
        headers: MapType = emptyMap()
    ): Result<String>

    suspend fun delete(
        url: String,
        headers: MapType = emptyMap()
    ): Result<String>
}


sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val error: ApiError) : Result<Nothing>()
}

sealed class ApiError {
    data object BadRequest : ApiError()
    data object Unauthorized : ApiError()
    data object Forbidden : ApiError()
    data object NotFound : ApiError()
    data object InternalServerError : ApiError()
    data object ServiceUnavailable : ApiError()
    data object Timeout : ApiError()
    data object Unknown : ApiError()
    data object NetWorkError : ApiError()
    data class CustomError(val statusCode: Int, val message: String) : ApiError()
}