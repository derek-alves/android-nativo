package com.composablecode.voyagerstudy.designSystem.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.composablecode.voyagerstudy.designSystem.customColors
import com.composablecode.voyagerstudy.designSystem.spacings
import org.jetbrains.compose.resources.ExperimentalResourceApi
import voyagerstudy.composeapp.generated.resources.Res


@OptIn(ExperimentalResourceApi::class)
@Composable
fun Avatar(
    size: Dp = MaterialTheme.spacings().xxxxxxl + MaterialTheme.spacings().sm,
    imageUrl: String,
) {
    AsyncImage(
        modifier = Modifier.border(
            width = 2.dp,
            color = MaterialTheme.customColors().dark,
            shape = CircleShape
        ).size(size)
            .clip(CircleShape),
        model = Res.getUri(imageUrl),
        contentDescription = "any",
    )
}