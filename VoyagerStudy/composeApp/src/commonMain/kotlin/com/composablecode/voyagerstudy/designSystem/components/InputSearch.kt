package com.composablecode.voyagerstudy.designSystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.spacings

@Composable
fun InputSearch(
    modifier: Modifier = Modifier,
    label: String,
    onValueChange: (String) -> Unit
) {
    val spacings = MaterialTheme.spacings()
    var text by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onValueChange(text)
            },
            textStyle = MaterialTheme.typography.h6.copy(textAlign = TextAlign.Center),
            singleLine = true,
            cursorBrush = SolidColor(Color.Black),
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (text.isEmpty()) {
                        Text(label, style = MaterialTheme.typography.h6)
                    }
                    innerTextField()
                }

            },
            modifier = modifier
                .fillMaxWidth().height(spacings.xxxxxl + 2.dp).drawBehind {
                    drawLine(
                        color = Color.Black.copy(alpha = 0.8f),
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = spacings.xxs.toPx()
                    )
                    drawLine(
                        color = Color.Black.copy(alpha = 0.8f),
                        start = Offset(0f, 0f),
                        end = Offset(0f, size.height),
                        strokeWidth = spacings.xxs.toPx()
                    )

                }.background(Color.White).weight(1f)
        )
        ButtonIcon(
            icon = AppIcon.Search
        )
    }
}