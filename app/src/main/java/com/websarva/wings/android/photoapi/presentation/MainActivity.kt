package com.websarva.wings.android.photoapi.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.websarva.wings.android.photoapi.presentation.photo_detail.PhotoDetailScreen
import com.websarva.wings.android.photoapi.presentation.search_photos.SearchPhotosScreen
import com.websarva.wings.android.photoapi.presentation.ui.theme.PhotoAPITheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.SearchPhotosScreen.route,
                    ) {
                        //画像検索画面
                        composable(route = ScreenRoute.SearchPhotosScreen.route){
                            SearchPhotosScreen(navController)
                        }
                        //詳細画面
                        composable(route = ScreenRoute.PhotoDetailScreen.route + "/{photoId}") {
                            PhotoDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
