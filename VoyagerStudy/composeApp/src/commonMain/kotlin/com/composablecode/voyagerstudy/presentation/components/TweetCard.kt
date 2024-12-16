package com.composablecode.voyagerstudy.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.components.Avatar
import com.composablecode.voyagerstudy.designSystem.components.Border
import com.composablecode.voyagerstudy.designSystem.components.ButtonIcon
import com.composablecode.voyagerstudy.designSystem.customColors
import com.composablecode.voyagerstudy.designSystem.spacings
import com.composablecode.voyagerstudy.domain.entity.Tweet

@Composable
fun TweetCard(modifier: Modifier = Modifier, tweet: Tweet) {
    val spacing = MaterialTheme.spacings()
    Border {
        Row(
            modifier = modifier.fillMaxWidth()
                .padding(
                    start = spacing.lg,
                    end = spacing.lg,
                    top = spacing.sm,
                    bottom = spacing.md
                ),
            verticalAlignment = Alignment.Top
        ) {
            Avatar(imageUrl = tweet.image)
            Spacer(modifier = Modifier.width(spacing.md))
            Column(
                verticalArrangement = Arrangement.Top
            ) {
                Row {
                    Text(text = tweet.userName, style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.width(spacing.xxs))
                    Text(
                        text = tweet.identifier,
                        style = MaterialTheme.typography.h6.copy(color = MaterialTheme.customColors().darkGray)
                    )
                }
                Spacer(modifier = Modifier.height(spacing.xs))
                Text(text = tweet.text, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(spacing.md))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(spacing.md)
                ) {
                    ButtonIcon(icon = AppIcon.Chat)
                    ButtonIcon(icon = AppIcon.Data)
                    ButtonIcon(icon = AppIcon.Hearth)
                    ButtonIcon(icon = AppIcon.Data)
                }

            }
        }

    }
}