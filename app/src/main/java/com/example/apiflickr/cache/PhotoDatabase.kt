package com.example.apiflickr.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PhotoInfoCacheEntity::class, PhotoCacheEntity::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {
    abstract val photoDao: PhotoDao
}