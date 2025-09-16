package com.example.androidapiapp.network

import com.example.androidapiapp.data.DashboardResponse
import com.example.androidapiapp.data.LoginRequest
import com.example.androidapiapp.data.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("{location}/auth")
    suspend fun login(
        @Path("location") location: String,
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(
        @Path("keypass") keypass: String
    ): Response<DashboardResponse>
}