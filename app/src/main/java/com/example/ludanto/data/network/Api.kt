package com.example.ludanto.data.network

import com.example.ludanto.data.dto.SessionResponse
import com.example.ludanto.data.dto.SongsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("oauth/token")
    suspend fun login(
        @Query(value = "grant_type") grantType: String,
        @Query(value = "client_id") clientId: String,
        @Query(value = "client_secret") clientSecret: String,
        @Query(value = "username") username: String,
        @Query(value = "password") password: String,
        @Query(value = "scope") scope: String,
    ): SessionResponse

    @GET("method/audio.get")
    suspend fun getMyPlaylist(
        @Query("access_token") token: String,
        @Query("user_id") userId: String,
        @Query("count") count: Int,
        @Query("offset") offset: Int

    ): SongsResponse.Holder

}