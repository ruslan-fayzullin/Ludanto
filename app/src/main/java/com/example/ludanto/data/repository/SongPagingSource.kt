package com.example.ludanto.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.ludanto.data.network.Api
import com.example.ludanto.data.storage.SessionStorage
import com.example.ludanto.domain.entity.Song
import com.example.ludanto.domain.mapper.SongsFromNetworkMapper
import kotlinx.coroutines.delay
import java.lang.Exception
import javax.inject.Inject

class SongPagingSource @Inject constructor(
    private val api: Api,
    private val mapSongFromNetwork: SongsFromNetworkMapper,
    private val sessionStorage: SessionStorage
) : PagingSource<Int, Song>() {

    override fun getRefreshKey(state: PagingState<Int, Song>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Song> {
        val offset = params.key ?: 0
        var totalCount = 0

        return sessionStorage.getSession().runCatching {
            api.getMyPlaylist(accessToken, userId, PAGE_SIZE, offset)
                .songsResponse
                .also { totalCount = it?.count ?: 0 }
                ?.run(mapSongFromNetwork) ?: emptyList()
        }
            .getOrNull()
            ?.let {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (offset <= totalCount) offset + PAGE_SIZE else null
                )
            } ?: LoadResult.Error(Throwable("Something went wrong"))
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}