package com.example.apiflickr.domain.photo

import com.example.apiflickr.domain.Page

interface PhotoRepository {
    fun searchPhotos(text: String, page: Int = 1): Page
    fun savePreviewPhotos(photos: List<PhotoEntity>)
    fun searchSavedPhotos(text:String): Page
    fun getPhotoInfo(id: String): PhotoInfoEntity
    fun getSavedPhotoInfo(id: String): PhotoInfoEntity?
    fun savePhotoInfo(photoInfo:PhotoInfoEntity)
}