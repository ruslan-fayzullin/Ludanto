package com.example.ludanto.data.dto


import com.google.gson.annotations.SerializedName

data class AlbumResponse(
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("owner_id")
    val ownerId: Int? = null,
    @SerializedName("thumb")
    val thumb: ThumbResponse? = null,
    @SerializedName("title")
    val title: String? = null
)