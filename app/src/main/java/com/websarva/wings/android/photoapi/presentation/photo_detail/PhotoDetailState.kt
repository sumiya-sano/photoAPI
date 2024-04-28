package com.websarva.wings.android.photoapi.presentation.photo_detail

import com.websarva.wings.android.photoapi.domain.model.PhotoDetail

data class PhotoDetailState(
    val isLoading: Boolean = false,
    val photoDetail: PhotoDetail? = null,
    val error: String? = null,
)
