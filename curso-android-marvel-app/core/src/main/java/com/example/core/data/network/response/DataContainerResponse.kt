package com.example.core.data.network.response

import com.google.gson.annotations.SerializedName

data class DataContainerResponse(
    @SerializedName("results")
    val result: List<CharacterResponse>
)
