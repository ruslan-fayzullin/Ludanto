package com.example.ludanto.presentation.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ludanto.R
import com.example.ludanto.presentation.ui.purple700

@Composable
fun Toolbar(onMenuItemCLick: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { ToolbarTitle() },
                navigationIcon = { NavigationIcon() },
                backgroundColor = purple700,
                contentColor = Color.White,
                elevation = 12.dp,
                actions = { Actions(onMenuItemCLick) }
            )
        },
        modifier = Modifier.height(48.dp).fillMaxWidth()
    ) {

    }

}

@Composable
fun ToolbarTitle() {
    Text(text = stringResource(id = R.string.app_name))
}

@Composable
fun Actions(onMenuItemCLick: () -> Unit = {}) {
    IconButton(onClick = onMenuItemCLick) {
        Icon(imageVector = Icons.Filled.Logout, contentDescription = "Logout")
    }
}

@Composable
fun NavigationIcon() {
    IconButton(onClick = { }) {
        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
    }
}