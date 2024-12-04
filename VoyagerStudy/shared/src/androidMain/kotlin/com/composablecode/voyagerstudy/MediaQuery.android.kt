package com.composablecode.voyagerstudy

import android.content.res.Resources

actual class MediaQuery actual constructor() {
    actual val width: Double
        get() = Resources.getSystem().displayMetrics.widthPixels.toDouble()

    actual val height: Double
        get() = Resources.getSystem().displayMetrics.heightPixels.toDouble()

    actual companion object {
        actual fun getInstance(): MediaQuery = MediaQuery()
    }
}