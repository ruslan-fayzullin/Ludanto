package com.example.ludanto.data.dto


import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("access_key")
    val accessKey: String? = null,
    @SerializedName("ads")
    val ads: AdsResponse? = null,
    @SerializedName("album")
    val album: AlbumResponse? = null,
    @SerializedName("artist")
    val artist: String? = null,
    @SerializedName("date")
    val date: Int? = null,
    @SerializedName("duration")
    val duration: Int? = null,
    @SerializedName("featured_artists")
    val featuredArtists: List<FeaturedArtistResponse>? = null,
    @SerializedName("genre_id")
    val genreId: Int? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("is_explicit")
    val isExplicit: Boolean? = null,
    @SerializedName("is_focus_track")
    val isFocusTrack: Boolean? = null,
    @SerializedName("is_licensed")
    val isLicensed: Boolean? = null,
    @SerializedName("main_artists")
    val mainArtists: List<MainArtistResponse>? = null,
    @SerializedName("owner_id")
    val ownerId: Int? = null,
    @SerializedName("short_videos_allowed")
    val shortVideosAllowed: Boolean? = null,
    @SerializedName("stories_allowed")
    val storiesAllowed: Boolean? = null,
    @SerializedName("stories_cover_allowed")
    val storiesCoverAllowed: Boolean? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("track_code")
    val trackCode: String? = null,
    @SerializedName("url")
    val url: String? = null
)