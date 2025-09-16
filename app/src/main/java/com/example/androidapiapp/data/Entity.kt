package com.example.androidapiapp.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
@Parcelize
data class Entity(
    @Json(name = "title") val title: String?,
    @Json(name = "author") val author: String?,
    @Json(name = "genre") val genre: String?,
    @Json(name = "publicationYear") val publicationYear: Int?,
    @Json(name = "description")val description: String?
): Parcelable

