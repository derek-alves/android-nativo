package com.composablecode.voyagerstudy.responsive

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class ResponsiveLayout(
    private val composable: @Composable () -> Unit,
    private val breakpoints: List<Breakpoint>
) {
    private fun orientation(windowWidth: Double, windowHeight: Double): Orientation {
        return if (windowWidth > windowHeight) Orientation.LANDSCAPE else Orientation.PORTRAIT
    }

    private fun currentBreakpoint(screenWidth: Double): Breakpoint {
        return breakpoints.firstOrNull {
            screenWidth >= it.start && screenWidth <= it.end
        } ?: Breakpoint(start = 0.0, end = 0.0)
    }


    @Composable
    fun Build(useShortestSide: Boolean = false) {
        var windowWidth by remember { mutableStateOf(0.0) }
        var windowHeight by remember { mutableStateOf(0.0) }
        var orientation by remember { mutableStateOf(Orientation.PORTRAIT) }
        var breakpoint by remember { mutableStateOf(Breakpoint(0.0, 0.0)) }

        BoxWithConstraints {
            val newWidth = maxWidth.value.toDouble()
            val newHeight = maxHeight.value.toDouble()

            if (newWidth != windowWidth || newHeight != windowHeight) {
                windowWidth = newWidth
                windowHeight = newHeight
            }
        }

        LaunchedEffect(windowWidth, windowHeight) {
            orientation = orientation(windowWidth, windowHeight)
            val screenWidth =
                if (useShortestSide) minOf(windowWidth, windowHeight) else windowWidth
            breakpoint = currentBreakpoint(screenWidth)
            print("breakpoint: ${breakpoint.type}  orientation: $orientation")
        }
        composable()
    }

}


data class Breakpoint(
    val start: Double,
    val end: Double,
    val type: BreakPointPlatform = BreakPointPlatform.NONE,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (other !is Breakpoint) return false

        return start == other.start &&
                end == other.end &&
                type == other.type
    }

    override fun hashCode(): Int {
        var result = start
        result = 31 * result + end
        result = 31 * result + type.hashCode()
        return result.toInt()
    }

}


enum class BreakPointPlatform {
    NONE,
    MOBILE,
    TABLET,
    DESKTOP
}

enum class Orientation {
    LANDSCAPE,
    PORTRAIT

}