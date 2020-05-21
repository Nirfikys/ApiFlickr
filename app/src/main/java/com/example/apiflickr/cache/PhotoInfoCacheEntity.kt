package com.example.apiflickr.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PhotoInfoCacheEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val url: String,
    val posted: Long,
    val comments: Int
)
