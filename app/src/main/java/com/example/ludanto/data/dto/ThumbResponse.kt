package com.example.ludanto.data.dto


import com.google.gson.annotations.SerializedName

data class ThumbResponse(
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("photo_1200")
    val photo1200: String? = null,
    @SerializedName("photo_135")
    val photo135: String? = null,
    @SerializedName("photo_270")
    val photo270: String? = null,
    @SerializedName("photo_300")
    val photo300: String? = null,
    @SerializedName("photo_34")
    val photo34: String? = null,
    @SerializedName("photo_600")
    val photo600: String? = null,
    @SerializedName("photo_68")
    val photo68: String? = null,
    @SerializedName("width")
    val width: Int? = null
)