package com.example.ludanto.domain.mapper

import com.example.ludanto.data.dto.ThumbResponse
import com.example.ludanto.domain.entity.Thumb
import javax.inject.Inject

class ThumbFromNetworkMapper @Inject constructor(): (ThumbResponse) -> Thumb {
    override fun invoke(response: ThumbResponse): Thumb =
        response.run {
            Thumb(
                height = height,
                photo_1200 = photo1200,
                photo_135 = photo135,
                photo_270 = photo270,
                photo_300 = photo300,
                photo_34 = photo34,
                photo_600 = photo600,
                photo_68 = photo68,
                width = width
            )
        }
}