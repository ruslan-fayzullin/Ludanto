package com.example.ludanto.domain.repository

import com.example.ludanto.data.repository.SongPagingSource

interface MusicRepository {
    fun getPagingSource(): SongPagingSource
}