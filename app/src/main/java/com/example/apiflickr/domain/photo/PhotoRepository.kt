package com.example.apiflickr.domain.photo

import com.example.apiflickr.domain.Page

interface PhotoRepository {
    fun searchPhotos(text: String, page: Int = 1): Page
}