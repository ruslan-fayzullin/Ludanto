package com.example.ludanto.domain.mapper

import com.example.ludanto.data.dto.AlbumResponse
import com.example.ludanto.domain.entity.Album
import javax.inject.Inject

class AlbumFromNetworkMapper @Inject constructor(
    private val mapThumbFromNetwork: ThumbFromNetworkMapper
): (AlbumResponse) -> Album {
    override fun invoke(response: AlbumResponse): Album =
        response.run {
            Album(
                access_key = accessKey,
                id = id,
                owner_id = ownerId,
                thumb = thumb?.run(mapThumbFromNetwork),
                title = title
            )
        }

}