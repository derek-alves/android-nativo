package com.composablecode.voyagerstudy.designSystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.spacings
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    leadIcon: AppIcon? = null,
    onClick: (() -> Unit)? = null
) {
    Border(
        modifier = modifier.clickable(enabled = onClick != null) { onClick?.invoke() }
    ) {
        Row(
            modifier = modifier.fillMaxWidth().height(MaterialTheme.spacings().xxxxxl).padding(
                horizontal = MaterialTheme.spacings().lg,
                vertical = MaterialTheme.spacings().xs
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            leadIcon?.let {
                Icon(
                    painter = painterResource(it.resId),
                    contentDescription = null,

                    modifier = modifier.size(MaterialTheme.spacings().xxxxl)
                        .padding(end = MaterialTheme.spacings().md),

                    )
            }
            Text(text = "Home", style = MaterialTheme.typography.h4)
        }
    }
}
