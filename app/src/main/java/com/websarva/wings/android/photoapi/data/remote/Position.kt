package com.websarva.wings.android.photoapi.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Position(
    val latitude: Double?,
    val longitude: Double?
)