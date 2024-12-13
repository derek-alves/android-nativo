package com.composablecode.voyagerstudy.designSystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.spacings
import org.jetbrains.compose.resources.painterResource

@Composable
fun ButtonIcon(icon: AppIcon, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Border(
        verticalStroke = 2.dp,
        horizontalStroke = 3.dp,
    ) {
        Box(
            modifier = modifier.size(MaterialTheme.spacings().xxxxl)
                .padding(MaterialTheme.spacings().sm)
        ) {
            Icon(
                painter = painterResource(icon.resId),
                contentDescription = null,
                modifier = modifier,
            )
        }

    }
}