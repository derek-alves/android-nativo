package com.composablecode.voyagerstudy.responsive

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MaxWidthBox(
    maxWidth: Dp? = null,
    alignment: Alignment = Alignment.TopCenter, // Alignment for the whole Box
    padding: Dp = 0.dp,
    backgroundColor: Color = Color.Transparent,
    content: @Composable () -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        // Calculate constrained width
        val constrainedWidth =
            maxWidth?.let { minOf(it, constraints.maxWidth.toDp(Density(1.5f))) }
                ?: constraints.maxWidth.toDp(Density(1.5f))

        // Outer Box centers the inner Box
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = alignment // Align the inner box in the parent
        ) {
            // Inner Box with size constraints and padding
            Box(
                modifier = Modifier
                    .sizeIn(maxWidth = constrainedWidth)
                    .padding(padding)
                    .background(backgroundColor)
            ) {
                content()
            }
        }
    }
}

fun Int.toDp(density: Density): Dp {
    return with(density) { this@toDp.toDp() }
}
