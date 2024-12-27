package com.composablecode.voyagerstudy.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Tweet(
    val id: Int,
    val userId: Int,
    val userName: String,
    val text: String,
    val likeQty: Int,
    val image: String?,
    val identifier: String?,
    val createdAt: Long?
)