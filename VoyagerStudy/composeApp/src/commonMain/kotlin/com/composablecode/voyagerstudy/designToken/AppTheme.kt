package com.composablecode.voyagerstudy.designToken

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun AppTheme(designSystemManager: DesignSystemManager, content: @Composable () -> Unit) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            primary = designSystemManager.colors["gray"] ?: Color.Unspecified,
            secondary = designSystemManager.colors["light gray"] ?: Color.Unspecified,
            background = designSystemManager.colors["gray"] ?: Color.Unspecified,
            surface = designSystemManager.colors["dark gray"] ?: Color.Unspecified,
            onPrimary = designSystemManager.colors["dark"] ?: Color.Unspecified,
            onSecondary = designSystemManager.colors["light"] ?: Color.Unspecified,
        ),

        typography = Typography(
            h1 = designSystemManager.typography["vt323 font"]?.get("xxl")
                ?: TextStyle.Default,
            h2 = designSystemManager.typography["vt323 font"]?.get("xl")
                ?: TextStyle.Default,
            h3 = designSystemManager.typography["vt323 font"]?.get("l")
                ?: TextStyle.Default,
            h4 = designSystemManager.typography["vt323 font"]?.get("m")
                ?: TextStyle.Default,
            h5 = designSystemManager.typography["vt323 font"]?.get("s")
                ?: TextStyle.Default,
            h6 = designSystemManager.typography["vt323 font"]?.get("xs")
                ?: TextStyle.Default,
        ),
        content = content
    )
}

data class AppColors(
    val dark: Color,
    val darkGray: Color,
    val gray: Color,
    val light: Color,
    val lightGray: Color,
)

@Composable
fun MaterialTheme.customColors(): AppColors {
    return AppColors(
        dark = colors.onPrimary,
        darkGray = colors.surface,
        gray = colors.primary,
        light = colors.onSecondary,
        lightGray = colors.secondary,
    )
}