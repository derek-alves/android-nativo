package com.example.meditation_ui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorPalette = darkColors(
    primary = TextWhite,
    primaryVariant = DarkerButtonBlue,
    secondary = OrangeYellow1,
    background = DeepBlue
)

private val LightColorPalette = lightColors(
    primary = TextWhite,
    primaryVariant = DarkerButtonBlue,
    secondary = OrangeYellow1,
    background = DeepBlue

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MeditationuiTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(LocalSpacing provides Spacing()) {
        MaterialTheme(
            colors = colors, typography = Typography, shapes = Shapes, content = content
        )
    }


}