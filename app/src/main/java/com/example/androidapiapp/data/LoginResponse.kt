package com.example.androidapiapp.data

import com.squareup.moshi.Json


data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)

