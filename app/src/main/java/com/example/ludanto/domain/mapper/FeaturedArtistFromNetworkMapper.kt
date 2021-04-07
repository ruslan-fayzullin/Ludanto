package com.example.ludanto.domain.mapper

import com.example.ludanto.data.dto.FeaturedArtistResponse
import com.example.ludanto.domain.entity.FeaturedArtist
import javax.inject.Inject

class FeaturedArtistFromNetworkMapper @Inject constructor(): (FeaturedArtistResponse) -> FeaturedArtist {
    override fun invoke(response: FeaturedArtistResponse): FeaturedArtist =
        response.run {
            FeaturedArtist(
                domain = domain,
                id = id,
                name = name
            )
        }
}