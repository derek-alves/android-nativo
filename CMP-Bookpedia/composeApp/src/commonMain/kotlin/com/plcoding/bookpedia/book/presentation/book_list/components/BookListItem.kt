import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cmp_bookpedia.composeapp.generated.resources.Res
import cmp_bookpedia.composeapp.generated.resources.book_error_2
import coil3.compose.rememberAsyncImagePainter
import com.plcoding.bookpedia.book.domain.Book
import com.plcoding.bookpedia.core.presentation.LightBlue
import com.plcoding.bookpedia.core.presentation.SandYellow
import org.jetbrains.compose.resources.painterResource
import kotlin.math.round

@Composable
fun BookListItem(
    book: Book,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Surface(
        shape = RoundedCornerShape(32.dp),
        modifier = modifier.clickable(onClick = onClick),
        color = LightBlue.copy(alpha = 0.2f),
    ) {
        Row(modifier = Modifier.padding(16.dp).fillMaxWidth().height(IntrinsicSize.Min)) {
            BookImage(book)
            Column(modifier = Modifier.fillMaxWidth().weight(1f)) {
                Text(
                    book.title,
                    style = MaterialTheme.typography.h2,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                book.authors.firstOrNull()?.let { authorName ->
                    Text(
                        text = authorName, style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                book.averageRating?.let { rating ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            "${round(rating * 10) / 10.0}",
                            style = MaterialTheme.typography.body2
                        )

                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = SandYellow
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun BookImage(book: Book) {
    Box(modifier = Modifier.height(100.dp), contentAlignment = Alignment.Center) {
        var imageLoadResult by remember {
            mutableStateOf<Result<Painter>?>(null)
        }
        val painter = rememberAsyncImagePainter(
            model = book.imageUrl,
            onSuccess = {
                imageLoadResult =
                    if (it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                        Result.success(it.painter)
                    } else {
                        Result.failure(Exception("invalid image"))
                    }
            },
            onError = {
                it.result.throwable.printStackTrace()
                imageLoadResult = Result.failure(it.result.throwable)
            }
        )
        when (val result = imageLoadResult) {
            null -> CircularProgressIndicator()
            else -> {
                Image(
                    painter = if (result.isSuccess) painter else painterResource(Res.drawable.book_error_2),
                    contentDescription = book.title,
                    contentScale = if (result.isSuccess) {
                        ContentScale.Crop
                    } else {
                        ContentScale.Fit
                    },
                    modifier = Modifier.aspectRatio(
                        0.65f,
                        matchHeightConstraintsFirst = true,
                    )
                )
            }
        }
    }
}