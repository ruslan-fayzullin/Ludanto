package com.example.ludanto.domain.mapper

import com.example.ludanto.data.dto.SessionResponse
import com.example.ludanto.domain.entity.Session
import javax.inject.Inject

class SessionFromNetworkMapper @Inject constructor() : (SessionResponse) -> Session {
    override fun invoke(response: SessionResponse): Session =
        response.run {
            Session(
                accessToken = accessToken,
                expiresIn = expiresIn,
                userId = userId
            )
        }
}