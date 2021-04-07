package com.example.ludanto.presentation.playlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import com.example.ludanto.presentation.view.Toolbar

@Composable
fun PlaylistScreen(playlistViewModel: PlaylistViewModel, onLogoutClick: () -> Unit) {
    val state = rememberLazyListState()
    val playlistPagingData = playlistViewModel.playlist
    Column {
        Toolbar(onMenuItemCLick = onLogoutClick)
        PlaylistContent(state = state, playlist = playlistPagingData)
    }
}