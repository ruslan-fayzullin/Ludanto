package com.example.ludanto.domain.repository

import com.example.ludanto.domain.entity.Session

interface AuthRepository {

    suspend fun login(username: String, password: String): Session
    suspend fun logout()

}