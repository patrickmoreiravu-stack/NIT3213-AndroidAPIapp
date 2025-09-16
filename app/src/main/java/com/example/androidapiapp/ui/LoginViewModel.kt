package com.example.androidapiapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapiapp.data.LoginResponse
import com.example.androidapiapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: Repository) : ViewModel() {

    private val _loginResult = MutableLiveData<LoginResponse?>()
    val loginResult: LiveData<LoginResponse?> = _loginResult

    fun login(location: String, username: String, password: String) {
        viewModelScope.launch {
            _loginResult.postValue(repo.login(location, username, password))
        }
    }
}