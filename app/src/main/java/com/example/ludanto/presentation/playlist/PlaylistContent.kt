package com.example.ludanto.presentation.playlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.ludanto.domain.entity.Song
import com.example.ludanto.presentation.view.ErrorItem
import com.example.ludanto.presentation.view.LoadingItem
import com.example.ludanto.presentation.view.LoadingView
import com.example.ludanto.presentation.view.SongItem
import kotlinx.coroutines.flow.Flow

@Composable
fun PlaylistContent(state : LazyListState, playlist: Flow<PagingData<Song>>) {
    val lazySongItems = playlist.collectAsLazyPagingItems()

    LazyColumn(state = state) {
        items(lazySongItems) { song ->
            song?.run {
                SongItem(
                    title = title.orEmpty(),
                    artist = artist.orEmpty(),
                    duration = duration ?: -1,
                    thumb = album?.thumb
                )
            }
        }
        lazySongItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = lazySongItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClick = { retry() }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazySongItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            onClick = { retry() }
                        )
                    }
                }
            }
        }
    }
}