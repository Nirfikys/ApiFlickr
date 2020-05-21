package com.example.apiflickr.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePhotoInfo(photoInfo: PhotoInfoCacheEntity)

    @Query("SELECT * FROM PhotoInfoCacheEntity")
    fun getPhoto(): List<PhotoInfoCacheEntity>

    @Query("SELECT * FROM PhotoInfoCacheEntity WHERE id = :id")
    fun getPhotoById(id: String): PhotoInfoCacheEntity?

    @Query("SELECT * FROM PhotoCacheEntity WHERE title LIKE '%' || :text || '%'")
    fun searchPhoto(text: String): List<PhotoCacheEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePhotoPreview(photos: List<PhotoCacheEntity>)

}