package com.composablecode.voyagerstudy.responsive

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.composablecode.voyagerstudy.responsive.utils.Orientation

val mediaQueryProvider = compositionLocalOf {
    MediaQuery(
        0.0,
        0.0,
        Breakpoint(start = 0.0, end = 0.0),
        Orientation.LANDSCAPE
    )
}

@Composable
fun ResponsiveLayout(
    landscapeBreakpoint: List<Breakpoint>? = null,
    breakpoints: List<Breakpoint>,
    useShortestSide: Boolean = false,
    composable: @Composable () -> Unit,
) {

    fun orientation(mediaQuery: MediaQuery): Orientation {
        return if (mediaQuery.width > mediaQuery.height) Orientation.LANDSCAPE else Orientation.PORTRAIT
    }

    fun currentBreakpoint(
        screenWidth: Double,
        isLandscape: Boolean = false
    ): Breakpoint {
        val currentBreakpoints =
            if (isLandscape) landscapeBreakpoint ?: breakpoints else breakpoints

        return currentBreakpoints.firstOrNull {
            screenWidth >= it.start && screenWidth <= it.end
        } ?: Breakpoint(start = 0.0, end = 0.0)
    }

    var mediaQuery by remember {
        mutableStateOf(
            MediaQuery(
                0.0,
                0.0,
                Breakpoint(start = 0.0, end = 0.0),
                Orientation.LANDSCAPE
            )
        )
    }

    BoxWithConstraints {
        val newWidth = maxWidth.value.toDouble()
        val newHeight = maxHeight.value.toDouble()

        if (newWidth != mediaQuery.width || newHeight != mediaQuery.height) {
            mediaQuery = mediaQuery.copy(width = newWidth, height = newHeight)

        }
    }

    LaunchedEffect(mediaQuery) {
        val screenWidth =
            if (useShortestSide) minOf(
                mediaQuery.width,
                mediaQuery.height
            ) else mediaQuery.width

        mediaQuery = mediaQuery.copy(
            breakpoint = currentBreakpoint(screenWidth),
            orientation = orientation(mediaQuery)
        )
    }

    CompositionLocalProvider(
        mediaQueryProvider provides mediaQuery
    ) {
        composable()
    }

}




