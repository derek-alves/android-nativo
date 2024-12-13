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
import androidx.compose.ui.unit.dp
import com.composablecode.voyagerstudy.designSystem.AppIcon
import com.composablecode.voyagerstudy.designSystem.spacings
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class ButtonType {
    Wrap, Expand,
}

enum class ButtonSize {
    Medium, Large
}

@Preview
@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    text: String,
    size: ButtonSize = ButtonSize.Medium,
    type: ButtonType = ButtonType.Expand,
    leadIcon: AppIcon? = null,
    onClick: (() -> Unit)? = null
) {
    val fontSize =
        if (size == ButtonSize.Medium) MaterialTheme.typography.h5 else MaterialTheme.typography.h4
    val buttonSize =
        if (size == ButtonSize.Medium) MaterialTheme.spacings().xxxxl else MaterialTheme.spacings().xxxxxxl + 2.dp
    Border(
        horizontalStroke = if (type == ButtonType.Wrap) 3.dp else 4.dp,
    ) {
        Row(
            modifier = modifier.height(buttonSize)
                .clickable(enabled = onClick != null) { onClick?.invoke() }.then(
                    if (type == ButtonType.Expand) Modifier.fillMaxWidth() else Modifier
                ).padding(
                    horizontal = MaterialTheme.spacings().lg,
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (leadIcon != null) Arrangement.Start else Arrangement.Center
        ) {
            leadIcon?.let {
                Icon(
                    painter = painterResource(it.resId),
                    contentDescription = null,

                    modifier = modifier.size(MaterialTheme.spacings().xxxxl)
                        .padding(end = MaterialTheme.spacings().md),

                    )
            }
            Text(text = text, style = fontSize)
        }
    }
}
