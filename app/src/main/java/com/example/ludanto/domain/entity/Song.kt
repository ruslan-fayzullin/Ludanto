package com.example.ludanto.domain.entity

data class Song(
    val access_key: String? = null,
    val ads: Ads? = null,
    val album: Album? = null,
    val artist: String? = null,
    val date: Int? = null,
    val duration: Int? = null,
    val featured_artists: List<FeaturedArtist>? = null,
    val genre_id: Int? = null,
    val id: Int? = null,
    val is_explicit: Boolean? = null,
    val is_focus_track: Boolean? = null,
    val is_licensed: Boolean? = null,
    val main_artists: List<MainArtist>? = null,
    val owner_id: Int? = null,
    val short_videos_allowed: Boolean? = null,
    val stories_allowed: Boolean? = null,
    val stories_cover_allowed: Boolean? = null,
    val subtitle: String? = null,
    val title: String? = null,
    val track_code: String? = null,
    val url: String? = null
)