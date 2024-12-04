package com.composablecode.voyagerstudy

import kotlinx.browser.window

actual class MediaQuery actual constructor() {
    actual val width: Double
        get() = window.innerWidth.toDouble()

    actual val height: Double
        get() = window.innerHeight.toDouble()

    actual companion object {
        actual fun getInstance(): MediaQuery = MediaQuery()
    }
}