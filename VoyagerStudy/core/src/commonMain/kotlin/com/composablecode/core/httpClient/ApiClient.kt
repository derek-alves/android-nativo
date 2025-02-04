import com.composablecode.core.httpClient.utils.MapType
import io.ktor.http.HttpMethod
import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer

interface ApiClient {
    suspend fun <T> request(
        method: HttpMethod,
        url: String,
        serializer: KSerializer<T>,
        headers: MapType = emptyMap(),
        body: Any? = null
    ): Result<T>
}

suspend inline fun <reified T> ApiClient.get(
    url: String,
    headers: MapType = emptyMap()
): Result<T> = request(
    method = HttpMethod.Get,
    url = url,
    serializer = serializer(),
    headers = headers
)

suspend inline fun <reified T> ApiClient.post(
    url: String,
    body: Any? = null,
    headers: MapType = emptyMap()
): Result<T> = request(
    method = HttpMethod.Post,
    url = url,
    serializer = serializer(),
    headers = headers,
    body = body
)
