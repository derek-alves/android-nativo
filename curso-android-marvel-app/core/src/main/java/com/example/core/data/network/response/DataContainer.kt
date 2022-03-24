package com.example.core.data.network.response

import com.google.gson.annotations.SerializedName

data class DataContainer(
    @SerializedName("results")
    val result: List<CharacterResponse>
)
