package com.composablecode.voyagerstudy.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Tweet(
    val id: String,
    val userName: String,
    val text: String,
    val likeQty: Int,
    val image: String,
    val identifier: String,
)