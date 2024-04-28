package com.websarva.wings.android.photoapi.domain.repository

import com.websarva.wings.android.photoapi.data.remote.PhotoDetailDto
import com.websarva.wings.android.photoapi.data.remote.SearchPhotosResultDto
import retrofit2.http.Query

interface PhotoRepository {

    suspend fun searchPhotos(query: String): SearchPhotosResultDto

    suspend fun getPhotoById(photoId: String):PhotoDetailDto
}