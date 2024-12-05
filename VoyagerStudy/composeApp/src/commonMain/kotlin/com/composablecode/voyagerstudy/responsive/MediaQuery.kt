package com.composablecode.voyagerstudy.responsive

import com.composablecode.voyagerstudy.responsive.utils.BreakPointPlatform
import com.composablecode.voyagerstudy.responsive.utils.Orientation

data class MediaQuery(
    val width: Double,
    val height: Double,
    val breakpoint: Breakpoint,
    val orientation: Orientation,
) {
    val isTable: Boolean
        get() = breakpoint.type == BreakPointPlatform.TABLET

    val isMobile: Boolean
        get() = breakpoint.type == BreakPointPlatform.MOBILE

    val isDesktop: Boolean
        get() = breakpoint.type == BreakPointPlatform.DESKTOP
}