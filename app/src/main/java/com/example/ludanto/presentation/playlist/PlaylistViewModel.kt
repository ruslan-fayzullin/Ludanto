package com.example.ludanto.presentation.playlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.ludanto.data.repository.SongPagingSource.Companion.PAGE_SIZE
import com.example.ludanto.domain.entity.Song
import com.example.ludanto.domain.repository.AuthRepository
import com.example.ludanto.domain.repository.MusicRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    val playlist: Flow<PagingData<Song>> =
        Pager(PagingConfig(pageSize = PAGE_SIZE)) { musicRepository.getPagingSource() }
            .flow
            .cachedIn(viewModelScope)

    fun logout() {
        viewModelScope.launch {
            authRepository.logout()
        }
    }
}