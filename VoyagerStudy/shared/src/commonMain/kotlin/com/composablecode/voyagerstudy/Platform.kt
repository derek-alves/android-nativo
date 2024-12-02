package com.composablecode.voyagerstudy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform