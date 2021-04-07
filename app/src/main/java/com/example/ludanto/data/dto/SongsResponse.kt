package com.example.ludanto.data.dto


import com.google.gson.annotations.SerializedName

data class SongsResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("items")
    val items: List<ItemResponse>? = null
) {
    data class Holder(
        @SerializedName("response")
        val songsResponse: SongsResponse? = null
    )
}