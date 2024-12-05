package com.composablecode.voyagerstudy.responsive

import com.composablecode.voyagerstudy.responsive.utils.BreakPointPlatform

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


