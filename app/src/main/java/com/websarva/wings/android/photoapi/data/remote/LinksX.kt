package com.websarva.wings.android.photoapi.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksX(
    val html: String?,
    val likes: String?,
    val photos: String?,
    val self: String?
)