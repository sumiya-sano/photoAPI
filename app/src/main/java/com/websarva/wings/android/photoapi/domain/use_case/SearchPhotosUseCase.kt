package com.websarva.wings.android.photoapi.domain.use_case

import com.websarva.wings.android.photoapi.common.NetworkResponse
import com.websarva.wings.android.photoapi.data.remote.toPhotos
import com.websarva.wings.android.photoapi.domain.model.Photo
import com.websarva.wings.android.photoapi.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.Query
import java.lang.Exception
import javax.inject.Inject

class SearchPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository,
) {
    operator fun invoke(query: String): Flow<NetworkResponse<List<Photo>>> = flow {
        try {
            emit(NetworkResponse.Loading<List<Photo>>())
            val photos = repository.searchPhotos(query).toPhotos()
            emit(NetworkResponse.Success<List<Photo>>(photos))
        } catch (e: Exception) {
            emit(NetworkResponse.Failure<List<Photo>>(e.message.toString()))
        }
    }
}