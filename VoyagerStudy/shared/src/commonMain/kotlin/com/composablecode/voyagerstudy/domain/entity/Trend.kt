package com.composablecode.voyagerstudy.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Trend(
    val category: String,
    val title: String,
    val counter: String
)
