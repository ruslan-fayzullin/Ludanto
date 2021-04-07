package com.example.ludanto.domain.mapper

import com.example.ludanto.data.dto.AdsResponse
import com.example.ludanto.domain.entity.Ads
import javax.inject.Inject

class AdsFromNetworkMapper @Inject constructor() : (AdsResponse) -> Ads {
    override fun invoke(response: AdsResponse): Ads =
        response.run {
            Ads(
                account_age_type = accountAgeType,
                content_id = contentId,
                duration = duration,
                puid1 = puid1,
                puid22 = puid22
            )
        }
}