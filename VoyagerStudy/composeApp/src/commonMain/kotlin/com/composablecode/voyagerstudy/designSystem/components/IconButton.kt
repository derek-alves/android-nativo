package com.composablecode.voyagerstudy.designSystem.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.spacings
import org.jetbrains.compose.resources.painterResource

@Composable
fun IconButton(icon: AppIcon, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Border(modifier = modifier.padding(MaterialTheme.spacings().sm), onClick = onClick) {
        Icon(
            painter = painterResource(icon.resId),
            contentDescription = null,
            modifier = modifier.size(MaterialTheme.spacings().xxxxl),

            )

    }
}