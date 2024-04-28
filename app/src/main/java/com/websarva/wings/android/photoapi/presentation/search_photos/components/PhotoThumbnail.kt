package com.websarva.wings.android.photoapi.presentation.search_photos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.websarva.wings.android.photoapi.data.remote.UnsplashApi
import com.websarva.wings.android.photoapi.domain.model.Photo
import com.websarva.wings.android.photoapi.presentation.components.CountLabel
import com.websarva.wings.android.photoapi.presentation.ui.theme.PhotoAPITheme

@Composable
fun PhotoThumbnail (
    photo: Photo,
    onClick: (Photo) -> Unit,
){
    Box(
        modifier = Modifier
            .background(Color.Black)
            .heightIn(min = 300.dp)
            .clickable { onClick(photo) },
        contentAlignment = Alignment.BottomCenter,
    ){
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
        AsyncImage(
            model = photo.imageUrl,
            contentDescription = photo.description,
            modifier = Modifier.fillMaxWidth(),
            )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(10.dp)
        ){
            Column(
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text(
                    text = photo.description ?: "No description",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = photo.photographer ?: "Unknown photographer",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            CountLabel(
                imageVector = Icons.Default.Favorite,
                count = photo.likes ?: 0,
                iconTint = Color.Magenta,
                color = Color.White,
            )
        }
    }
}

@Preview
@Composable
private fun PhotoThumbnailPreview(){
    val photo = Photo(
        photoId = "",
        description = "Image description",
        likes = 100,
        imageUrl = "https://plus.unsplash.com/premium_photo-1669689974101-55f9aea22158?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHwxfHx8ZW58MHx8fHx8",
        photographer = "hogehoge"
    )
    PhotoAPITheme {
        PhotoThumbnail(photo = photo, onClick = {})
    }
}