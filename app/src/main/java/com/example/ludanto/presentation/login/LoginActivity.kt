package com.example.ludanto.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.ludanto.presentation.playlist.PlaylistActivity
import com.example.ludanto.presentation.ui.LudantoTheme
import com.example.ludanto.presentation.view.EditText16
import com.example.ludanto.presentation.view.OutlinedButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LudantoTheme {
                Surface(Modifier.background(color = Color.White)) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column {
                            val username by viewModel.username.observeAsState()
                            val password by viewModel.password.observeAsState()
                            EditText16(
                                label = "Login",
                                value = username.orEmpty(),
                                keyboardType = KeyboardType.Email,
                                onValueChange = viewModel::setUsername)
                            EditText16(
                                label = "Password",
                                value = password.orEmpty(),
                                keyboardType = KeyboardType.Password,
                                onValueChange = viewModel::setPassword,
                                visualTransformation = PasswordVisualTransformation())
                            OutlinedButton(label = "LOGIN") {
                                viewModel.login(username.orEmpty(), password.orEmpty())
                            }
                        }
                    }
                }
            }
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.sessionData.observe(this) {
            startActivity(Intent(this, PlaylistActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }
        viewModel.errorData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }
}