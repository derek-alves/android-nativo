package com.composablecode.voyagerstudy.designSystem

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

val LocalSpacing = staticCompositionLocalOf<Spacing> { Spacing() }

@Composable
fun AppTheme(designSystemManager: DesignSystemManager, content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalSpacing provides designSystemManager.spacings
    ) {
        MaterialTheme(
            colors = MaterialTheme.colors.copy(
                primary = designSystemManager.colors["gray"] ?: Color.Unspecified,
                secondary = designSystemManager.colors["light gray"] ?: Color.Unspecified,
                background = designSystemManager.colors["gray"] ?: Color.Unspecified,
                surface = designSystemManager.colors["dark gray"] ?: Color.Unspecified,
                onPrimary = designSystemManager.colors["dark"] ?: Color.Unspecified,
                onSecondary = designSystemManager.colors["light"] ?: Color.Unspecified,
                primaryVariant = designSystemManager.colors["gray-medium"] ?: Color.Unspecified,
            ),

            typography = Typography(
                defaultFontFamily = designSystemManager.DesignSystemFont(),
                h1 = designSystemManager.typography["vt323 font"]?.get("xxl")
                    ?.copy(color = designSystemManager.colors["dark"] ?: Color.Unspecified)
                    ?: TextStyle.Default,
                h2 = designSystemManager.typography["vt323 font"]?.get("xl")
                    ?.copy(color = designSystemManager.colors["dark"] ?: Color.Unspecified)
                    ?: TextStyle.Default,
                h3 = designSystemManager.typography["vt323 font"]?.get("l")
                    ?.copy(color = designSystemManager.colors["dark"] ?: Color.Unspecified)
                    ?: TextStyle.Default,
                h4 = designSystemManager.typography["vt323 font"]?.get("m")
                    ?.copy(color = designSystemManager.colors["dark"] ?: Color.Unspecified)
                    ?: TextStyle.Default,
                h5 = designSystemManager.typography["vt323 font"]?.get("s")
                    ?.copy(color = designSystemManager.colors["dark"] ?: Color.Unspecified)
                    ?: TextStyle.Default,
                h6 = designSystemManager.typography["vt323 font"]?.get("xs")
                    ?.copy(color = designSystemManager.colors["dark"] ?: Color.Unspecified)
                    ?: TextStyle.Default,
            ),
            content = content
        )
    }

}

data class AppColors(
    val dark: Color,
    val darkGray: Color,
    val gray: Color,
    val grayMedium: Color,
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
        grayMedium = colors.primaryVariant,
    )
}






