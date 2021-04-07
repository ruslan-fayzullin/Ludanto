package com.example.ludanto.data.dto


import com.google.gson.annotations.SerializedName

data class AdsResponse(
    @SerializedName("account_age_type")
    val accountAgeType: String? = null,
    @SerializedName("content_id")
    val contentId: String? = null,
    @SerializedName("duration")
    val duration: String? = null,
    @SerializedName("puid1")
    val puid1: String? = null,
    @SerializedName("puid22")
    val puid22: String? = null
)