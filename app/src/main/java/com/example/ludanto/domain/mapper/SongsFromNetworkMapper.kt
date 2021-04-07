package com.example.ludanto.domain.mapper

import android.util.Log
import com.example.ludanto.data.dto.SongsResponse
import com.example.ludanto.domain.entity.*
import javax.inject.Inject

class SongsFromNetworkMapper @Inject constructor(
    private val mapAdsFromNetwork: AdsFromNetworkMapper,
    private val mapAlbumFromNetwork: AlbumFromNetworkMapper,
    private val mapFeaturedArtistFromNetwork: FeaturedArtistFromNetworkMapper,
    private val mapMainArtistFromNetwork: MainArtistFromNetworkMapper
) : (SongsResponse) -> List<Song> {
    override fun invoke(response: SongsResponse): List<Song> =
        response.items?.map { item ->
            item.run {
                Song(
                    access_key = accessKey,
                    ads = ads?.run(mapAdsFromNetwork),
                    album = album?.run(mapAlbumFromNetwork),
                    artist = artist,
                    date = date,
                    duration = duration,
                    featured_artists = featuredArtists?.map { featuredArtist ->
                        featuredArtist.run(mapFeaturedArtistFromNetwork)
                    },
                    genre_id = genreId,
                    id = id,
                    is_explicit = isExplicit,
                    is_focus_track = isFocusTrack,
                    is_licensed = isLicensed,
                    main_artists = mainArtists?.map { mainArtists ->
                        mainArtists.run(mapMainArtistFromNetwork)
                    },
                    owner_id = ownerId,
                    short_videos_allowed = shortVideosAllowed,
                    stories_allowed = storiesAllowed,
                    stories_cover_allowed = storiesCoverAllowed,
                    subtitle = subtitle,
                    title = title,
                    track_code = trackCode,
                    url = url
                )
            }
        } ?: emptyList()
}