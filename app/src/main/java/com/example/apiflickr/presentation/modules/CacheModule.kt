package com.example.apiflickr.presentation.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.apiflickr.cache.PhotoCacheImpl
import com.example.apiflickr.cache.PhotoDao
import com.example.apiflickr.cache.PhotoDatabase
import com.example.apiflickr.domain.photo.PhotoCache
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {
    @Singleton
    @Provides
    fun provideApiService(context: Context): PhotoDao {
        return Room.databaseBuilder(context, PhotoDatabase::class.java, "photos")
            .fallbackToDestructiveMigration()
            .build().photoDao
    }

    @Singleton
    @Provides
    fun provideMovieCache(photoDao: PhotoDao): PhotoCache {
        return PhotoCacheImpl(photoDao)
    }
}