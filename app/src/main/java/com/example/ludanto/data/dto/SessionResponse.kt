package com.example.ludanto.data.dto


import com.google.gson.annotations.SerializedName

data class SessionResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("expires_in")
    val expiresIn: Int,
    @SerializedName("user_id")
    val userId: String
)