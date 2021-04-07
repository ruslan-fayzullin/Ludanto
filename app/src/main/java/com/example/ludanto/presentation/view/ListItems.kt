package com.example.ludanto.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ludanto.R
import com.example.ludanto.domain.entity.Thumb
import com.google.accompanist.glide.GlideImage

@Composable
fun SongItem(
    title: String,
    artist: String,
    duration: Int,
    thumb: Thumb?
) {
    val durationReadable = "${duration / 60}:${duration % 60}"
    Row(modifier = Modifier.fillMaxWidth()) {
        thumb?.photo_135?.let {
            GlideImage(
                data = it,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentDescription = "Album Thumb"
            ) {}
        } ?: run {
            Image(
                painter = painterResource(R.drawable.ic_baseline_music_note_24),
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(16.dp),
                contentDescription = "Album Thumb"
            )
        }
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.height(100.dp)) {
            Text(text = artist, fontSize = 16.sp)
            Text(text = title, fontSize = 12.sp)
            Text(text = durationReadable, fontSize = 12.sp)
        }
    }
}

@Composable
fun LoadingItem() {
    CircularProgressIndicator(modifier = Modifier
        .height(48.dp)
        .fillMaxWidth())
}
@Composable
fun ErrorItem(message: String, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {
    TextButton(onClick = onClick, modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Text(text = message)
            Text(text = "Tap to retry")
        }
    }
}

@Preview
@Composable
fun SongItemPreview() {
    SongItem(
        title = "Blood Sugar",
        artist = "Pendulum",
        duration = 139,
        thumb = Thumb(0, "", "", "", "", "", "", "", 0)
    )
}