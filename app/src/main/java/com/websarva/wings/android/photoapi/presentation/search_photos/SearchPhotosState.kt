package com.websarva.wings.android.photoapi.presentation.search_photos

import com.websarva.wings.android.photoapi.domain.model.Photo

data class SearchPhotosState(
    val isLoading: Boolean = false,
    val photos: List<Photo> = emptyList(),
    val error: String? = null,
)
