package com.example.apiflickr.domain

interface PhotoRemote {
    fun searchPhotos(text: String, page: Int = 1): Page
}