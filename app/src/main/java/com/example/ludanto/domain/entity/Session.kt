package com.example.ludanto.domain.entity

data class Session(
    val accessToken: String,
    val expiresIn: Int,
    val userId: String
)
