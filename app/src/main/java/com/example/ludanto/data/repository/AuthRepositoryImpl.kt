package com.example.ludanto.data.repository

import com.example.ludanto.BuildConfig
import com.example.ludanto.data.network.Api
import com.example.ludanto.data.storage.SessionStorage
import com.example.ludanto.domain.repository.AuthRepository
import com.example.ludanto.domain.entity.Session
import com.example.ludanto.domain.mapper.SessionFromNetworkMapper
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: Api,
    private val mapSessionFromNetwork: SessionFromNetworkMapper,
    private val sessionStorage: SessionStorage
) : AuthRepository {
    override suspend fun login(username: String, password: String): Session =
        api.login(
            grantType = BuildConfig.GRANT_TYPE,
            clientId = BuildConfig.CLIENT_ID,
            clientSecret = BuildConfig.CLIENT_SECRET,
            username = username,
            password = password,
            scope = BuildConfig.SCOPE
        )
            .run(mapSessionFromNetwork)
            .also(sessionStorage::saveSession)

    override suspend fun logout() {
        sessionStorage.clearSession()
    }

}