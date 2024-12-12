package com.composablecode.voyagerstudy.designToken

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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
            ),

            typography = Typography(
                defaultFontFamily = designSystemManager.DesignSystemFont(),
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

data class DpSpacing(
    val xs: Dp,
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
    val xxl: Dp,
    val xxxl: Dp,
    val xxxxl: Dp,
    val xxxxxl: Dp,
    val xxxxxxl: Dp
)

@Composable
fun MaterialTheme.spacings(): DpSpacing {
    return DpSpacing(
        xs = LocalSpacing.current.xs.dp,
        sm = LocalSpacing.current.sm.dp,
        md = LocalSpacing.current.md.dp,
        lg = LocalSpacing.current.lg.dp,
        xl = LocalSpacing.current.xl.dp,
        xxl = LocalSpacing.current.xxl.dp,
        xxxl = LocalSpacing.current.xxxl.dp,
        xxxxl = LocalSpacing.current.xxxxl.dp,
        xxxxxl = LocalSpacing.current.xxxxxl.dp,
        xxxxxxl = LocalSpacing.current.xxxxxxl.dp,
    )
}




