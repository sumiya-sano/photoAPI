package com.websarva.wings.android.photoapi.presentation.photo_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.websarva.wings.android.photoapi.domain.model.PhotoDetail
import com.websarva.wings.android.photoapi.presentation.components.CountLabel

@Composable
fun PhotoDetailScreen(
    viewModel: PhotoDetailViewModel = hiltViewModel(),
){
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
         when{
             state.isLoading -> {
                 CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
             }

             !state.error.isNullOrBlank() ->{
                 Text(
                     text = state.error,
                     modifier = Modifier.align(Alignment.Center),
                     color = MaterialTheme.colorScheme.error
                 )
             }

             else -> {
                 state.photoDetail?.let { photoDetail ->
                     PhotoDetailContent(photoDetail = photoDetail )
                 }
             }
         }
    }
}

@Composable
fun PhotoDetailContent(photoDetail: PhotoDetail){
    Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier.heightIn(min = 300.dp)){
            var isLoadingImage by remember { mutableStateOf(true) }
            if (isLoadingImage){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                )
            }
            AsyncImage(
                model = photoDetail.imageUrl,
                contentDescription = photoDetail.description,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStartPercent = 0,
                            topEndPercent = 0,
                            bottomStartPercent = 0,
                            bottomEndPercent = 0,
                        )
                    ),
                onSuccess = { isLoadingImage = false }
            )
        }
        Column (modifier = Modifier.padding(10.dp)) {
            Text(
                text = photoDetail.description ?: "No description",
                style = MaterialTheme.typography.headlineMedium
                )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text =photoDetail.photographer ?: "UnKnown Photographer",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(20.dp))
            CountLabel(
                imageVector = Icons.Default.Favorite,
                count = photoDetail.likes ?: 0,
                iconTint = Color.Magenta,
                )
            CountLabel(
                imageVector = Icons.Default.Share,
                count = photoDetail.downloads ?: 0,
                iconTint = Color.Green,
                )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Camera: ${photoDetail.camera}")
            Text(text = "Location: ${photoDetail.location}")
        }
    }
}