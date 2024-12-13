package com.composablecode.voyagerstudy.designSystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Border(
    verticalStroke: Dp = 3.dp,
    horizontalStroke: Dp = 5.dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .background(color = MaterialTheme.colors.primary)
            .drawBehind {
                drawLine(
                    color = Color.White.copy(alpha = 0.6f),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = verticalStroke.toPx()
                )
                drawLine(
                    color = Color.White.copy(alpha = 0.6f),
                    start = Offset(0f, 0f),
                    end = Offset(0f, size.height),
                    strokeWidth = horizontalStroke.toPx()
                )
                drawLine(
                    color = Color.Black.copy(alpha = 0.8f),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = verticalStroke.toPx()
                )
                drawLine(
                    color = Color.Black.copy(alpha = 0.8f),
                    start = Offset(size.width, 0f),
                    end = Offset(size.width, size.height),
                    strokeWidth = horizontalStroke.toPx()
                )
            }
            .padding(4.dp)
    ) {
        content()
    }
}
