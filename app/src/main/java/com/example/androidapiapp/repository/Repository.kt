package com.example.androidapiapp.repository


import com.example.androidapiapp.data.DashboardResponse
import com.example.androidapiapp.data.LoginRequest
import com.example.androidapiapp.data.LoginResponse
import com.example.androidapiapp.network.ApiService
import javax.inject.Inject

class Repository @Inject constructor(private val api: ApiService) {

    suspend fun login(location: String, username: String, password: String): LoginResponse? {
        val response = api.login(location, LoginRequest(username, password))
        return if (response.isSuccessful) response.body() else null
    }

    suspend fun getDashboard(keypass: String): DashboardResponse? {
        val response = api.getDashboard(keypass)
        return if (response.isSuccessful) response.body() else null
    }
}