package com.example.apiflickr.domain.photo

import com.example.apiflickr.domain.Page
import com.example.apiflickr.domain.photo.PhotoInfoEntity

interface PhotoCache {
    fun savePhotosInfo(photos: List<PhotoInfoEntity>)
    fun savePhotosPreview(photos: List<PhotoEntity>)
    fun searchPhotos(text: String, page: Int = 1): Page
    fun getPhotoInfo(id: String): PhotoInfoEntity?
}