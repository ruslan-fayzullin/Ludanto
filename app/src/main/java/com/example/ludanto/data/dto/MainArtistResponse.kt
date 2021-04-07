package com.example.ludanto.data.dto


import com.google.gson.annotations.SerializedName

data class MainArtistResponse(
    @SerializedName("domain")
    val domain: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)