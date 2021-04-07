package com.example.ludanto.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ludanto.data.storage.SessionStorage
import com.example.ludanto.domain.repository.AuthRepository
import com.example.ludanto.domain.entity.Session
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val sessionStorage: SessionStorage
) : ViewModel() {


    private val sessionMutableData = MutableLiveData<Session>()
    val sessionData: LiveData<Session> = sessionMutableData
    private val errorMutableData = MutableLiveData<String>()
    val errorData: LiveData<String> = errorMutableData

    private val usernameMutable = MutableLiveData<String>()
    val username : LiveData<String> = usernameMutable
    private val passwordMutable = MutableLiveData<String>()
    val password : LiveData<String> = passwordMutable

    init {
        checkIfSessionExists()
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            runCatching {
                authRepository.login(username, password)
            }
                .onSuccess(sessionMutableData::setValue)
                .onFailure {errorMutableData.value = it.message }
        }
    }

    fun setUsername(username: String) {
        usernameMutable.value = username
    }

    fun setPassword(password: String) {
        passwordMutable.value = password
    }

    private fun checkIfSessionExists() {
        viewModelScope.launch {
            if (sessionStorage.isSessionExists()) {
                sessionStorage.getSession().run(sessionMutableData::setValue)
            }
        }
    }

}