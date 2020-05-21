package com.example.apiflickr.presentation.modules

import android.content.Context
import com.example.apiflickr.domain.photo.PhotoCache
import com.example.apiflickr.domain.photo.PhotoRemote
import com.example.apiflickr.domain.photo.PhotoRepository
import com.example.apiflickr.domain.photo.PhotoRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideAppContext(): Context = context


    @Provides
    @Singleton
    fun provideMovieRepository(cache: PhotoCache, photoRemote: PhotoRemote): PhotoRepository {
        return PhotoRepositoryImpl(photoRemote, cache)
    }
}