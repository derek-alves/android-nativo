package com.composablecode.voyagerstudy.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.Avatar
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.spacings

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = MaterialTheme.spacings().md),
    content: (@Composable () -> Unit)? = null
) {
    Box(
        modifier = modifier.drawBehind {
            val strokeWidth = 2.dp.toPx()
            drawLine(
                color = Color.Black,
                start = Offset(
                    0f,
                    size.height
                ),
                end = Offset(
                    size.width,
                    size.height
                ),
                strokeWidth = strokeWidth
            )
        }.fillMaxWidth().padding(
            vertical = MaterialTheme.spacings().sm,
            horizontal = MaterialTheme.spacings().lg
        )
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Avatar(
                    imageUrl = "drawable/images/avatar-1.png"
                )
                if (content != null) {
                    Box(
                        modifier = modifier
                            .padding(
                                contentPadding
                            )

                    ) {
                        content.invoke()
                    }
                }
            }

            ButtonIcon(
                icon = AppIcon.OpenPoints
            )
        }
    }
}