package com.composablecode.core

import com.composablecode.core.httpClient.ApiClientImpl
import com.composablecode.core.httpClient.ApiError
import com.composablecode.core.httpClient.get
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertIs
import kotlin.test.assertTrue

class ApiClientTest {

    @Serializable
    data class TestData(val id: Int, val name: String)

    @Serializable
    data class TestComplexData(val id: Int, val name: String, val values: List<TestData>)

    private val fakeHttpClient = HttpClient(MockEngine) {
        engine {
            addHandler { request ->
                when (request.url.encodedPath) {
                    "/success" -> respond(
                        content = """{"id": 1, "name": "Test"}""",
                        status = HttpStatusCode.OK,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )

                    "/complex-success" -> respond(
                        content = """{
                                    "id": 100,
                                    "name": "Complex Test",
                                    "values": [
                                     {"id": 1, "name": "Test 1"},
                                     {"id": 2, "name": "Test 2"}
                                      ]
                                 }""",
                        status = HttpStatusCode.OK,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )

                    "/invalid-json" -> respond(
                        content = """{"invalid": "json"}""",
                        status = HttpStatusCode.OK,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )

                    "/error-request-400" -> respond(
                        content = """{"invalid": "json"}""",
                        status = HttpStatusCode.BadRequest,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )

                    "/error-request-401" -> respond(
                        content = """{"invalid": "json"}""",
                        status = HttpStatusCode.Unauthorized,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )

                    "/error-request-403" -> respond(
                        content = """{"invalid": "json"}""",
                        status = HttpStatusCode.Forbidden,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )

                    "/error-request-404" -> respond(
                        content = """{"invalid": "json"}""",
                        status = HttpStatusCode.NotFound,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )

                    "/error-request-500" -> respond(
                        content = """{"invalid": "json"}""",
                        status = HttpStatusCode.InternalServerError,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )

                    "/error-request-503" -> respond(
                        content = """{"invalid": "json"}""",
                        status = HttpStatusCode.Forbidden,
                        headers = headersOf("Content-Type" to listOf("application/json"))
                    )


                    else -> respondError(HttpStatusCode.NotFound, "URL não encontrada")
                }
            }
        }
    }
    private val apiClient = ApiClientImpl(fakeHttpClient)


    @Test
    fun `test serialize a complex object`() = runTest {
        val result = apiClient.get<TestComplexData>("/complex-success")
        assertTrue(result.isSuccess)
        val data = result.getOrNull()
        assertIs<TestComplexData>(data)
        assertTrue(data.id == 100)
        assertTrue(data.name == "Complex Test")
        assertIs<List<TestData>>(data.values)
    }

    @Test
    fun `test GET request return success on 200 ok`() = runTest {
        val result = apiClient.get<TestData>("/success")
        assertTrue(result.isSuccess)
        val data = result.getOrNull()
        assertIs<TestData>(data)
        assertTrue(data.id == 1)
        assertTrue(data.name == "Test")
    }

    @Test
    fun `test GET request return failure on invalid json`() = runTest {
        val result = apiClient.get<TestData>("/invalid-json")
        assertTrue(result.isFailure)
        assertIs<ApiError.SerializationError>(result.exceptionOrNull())

    }

    @Test
    fun `test GET request return BadRequest`() = runTest {
        val result = apiClient.get<TestData>("/error-request-400")
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ApiError.BadRequest)
    }

    @Test
    fun `test GET request return Unauthorized`() = runTest {
        val result = apiClient.get<TestData>("/error-request-401")
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ApiError.Unauthorized)
    }

    @Test
    fun `test GET request return Forbidden`() = runTest {
        val result = apiClient.get<TestData>("/error-request-403")
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ApiError.Forbidden)
    }

    @Test
    fun `test GET request return NotFound`() = runTest {
        val result = apiClient.get<TestData>("/error-request-404")
        assertTrue(result.isFailure)
        assertIs<ApiError.NotFound>(result.exceptionOrNull())
    }

    @Test
    fun `test GET request return Internal server error`() = runTest {
        val result = apiClient.get<TestData>("/error-request-500")
        assertTrue(result.isFailure)
        assertIs<ApiError.InternalServerError>(result.exceptionOrNull())
    }

}