package com.example.apiflickr.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoCacheEntity(
    @PrimaryKey
    val id: String,
    val url: String,
    val title: String
)