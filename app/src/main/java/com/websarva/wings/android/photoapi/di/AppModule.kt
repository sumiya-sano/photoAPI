package com.websarva.wings.android.photoapi.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.websarva.wings.android.photoapi.common.Constants.BASE_URL
import com.websarva.wings.android.photoapi.data.remote.UnsplashApi
import com.websarva.wings.android.photoapi.data.repository.PhotoRepositoryImpl
import com.websarva.wings.android.photoapi.domain.repository.PhotoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.UnstableApi
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideUnsplashApi(): UnsplashApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(UnsplashApi::class.java)
    }

    @Provides
    @Singleton
    fun providePhotoRepository(api: UnsplashApi): PhotoRepository{
        return PhotoRepositoryImpl(api)
    }
}