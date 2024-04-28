package com.websarva.wings.android.photoapi.presentation

sealed class ScreenRoute (val route:String){
    object SearchPhotosScreen : ScreenRoute("search_photos_screen")
    object PhotoDetailScreen: ScreenRoute("photo_detail_screen")
}