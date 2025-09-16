package com.example.androidapiapp.data

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)
