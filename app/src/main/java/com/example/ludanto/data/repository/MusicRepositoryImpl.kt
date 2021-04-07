package com.example.ludanto.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.*
import com.example.ludanto.data.network.Api
import com.example.ludanto.data.repository.SongPagingSource.Companion.PAGE_SIZE
import com.example.ludanto.data.storage.SessionStorage
import com.example.ludanto.domain.entity.Song
import com.example.ludanto.domain.mapper.SongsFromNetworkMapper
import com.example.ludanto.domain.repository.MusicRepository
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val songPagingSource: SongPagingSource
) : MusicRepository {

    override fun getPagingSource(): SongPagingSource = songPagingSource

}