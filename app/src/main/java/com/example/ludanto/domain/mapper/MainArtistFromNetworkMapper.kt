package com.example.ludanto.domain.mapper

import com.example.ludanto.data.dto.MainArtistResponse
import com.example.ludanto.domain.entity.MainArtist
import javax.inject.Inject

class MainArtistFromNetworkMapper @Inject constructor(): (MainArtistResponse) -> MainArtist {
    override fun invoke(response: MainArtistResponse): MainArtist =
        response.run {
            MainArtist(
                domain = domain,
                id = id,
                name = name
            )
        }
}