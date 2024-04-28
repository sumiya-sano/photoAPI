package com.websarva.wings.android.photoapi.data.repository

import com.websarva.wings.android.photoapi.data.remote.PhotoDetailDto
import com.websarva.wings.android.photoapi.data.remote.SearchPhotosResultDto
import com.websarva.wings.android.photoapi.data.remote.UnsplashApi
import com.websarva.wings.android.photoapi.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private  val  api: UnsplashApi,
) : PhotoRepository {

    override suspend fun searchPhotos(query: String): SearchPhotosResultDto {
        return  api.searchPhotos(query)
    }

    override suspend fun getPhotoById(photoId: String): PhotoDetailDto {
        return api.getPhotoById((photoId))
    }
}