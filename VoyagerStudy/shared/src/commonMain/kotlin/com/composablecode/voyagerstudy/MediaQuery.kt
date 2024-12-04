package com.composablecode.voyagerstudy

expect class MediaQuery() {
    val width: Double
    val height: Double

    companion object {
        fun getInstance(): MediaQuery
    }
}