package com.composablecode.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform