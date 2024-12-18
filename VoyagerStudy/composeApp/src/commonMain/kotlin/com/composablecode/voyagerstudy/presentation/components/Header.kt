package com.composablecode.voyagerstudy.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.Avatar
import com.composablecode.voyagerstudy.designSystem.components.Border
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.components.ButtonPrimary
import com.composablecode.voyagerstudy.designSystem.components.ButtonType
import com.composablecode.voyagerstudy.designSystem.customColors
import com.composablecode.voyagerstudy.designSystem.spacings

@Composable
fun Header(modifier: Modifier = Modifier) {
    val spacing = MaterialTheme.spacings()
    val colors = MaterialTheme.customColors()
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Border {
        Box(
            modifier = modifier.fillMaxWidth().height(160.dp).padding(
                start = spacing.lg,
                end = spacing.lg,
                bottom = spacing.md,
                top = spacing.sm
            )
        ) {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(spacing.md)
                ) {
                    Avatar(imageUrl = "drawable/images/avatar-1.png")
                    BasicTextField(
                        value = text,
                        onValueChange = { text = it },
                        maxLines = 3,
                        textStyle = MaterialTheme.typography.h5.copy(color = colors.dark),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent),
                        decorationBox = { innerTextField ->
                            if (text.text.isEmpty()) {
                                Text(
                                    text = "What’s\nhappening?",
                                    style = MaterialTheme.typography.h5.copy(color = colors.darkGray),
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                            innerTextField()
                        },
                    )
                }

                Column {
                    Spacer(modifier = Modifier.fillMaxWidth().height(1.dp).background(colors.dark))
                    Spacer(modifier = Modifier.height(spacing.lg))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(spacing.xs),
                        ) {
                            ButtonIcon(icon = AppIcon.Picture)
                            ButtonIcon(icon = AppIcon.Face)
                            ButtonIcon(icon = AppIcon.Calendar)
                            ButtonIcon(icon = AppIcon.PointMap)
                        }

                        ButtonPrimary(
                            type = ButtonType.Wrap,
                            text = "Tweet"
                        )
                    }
                }

            }
        }


    }

}