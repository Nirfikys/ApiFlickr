package com.example.apiflickr.domain.photo

import com.example.apiflickr.domain.Page

interface PhotoRemote {
    fun searchPhotos(text: String, page: Int = 1): Page
    fun getPhotoInfo(id: String): PhotoInfoEntity
}