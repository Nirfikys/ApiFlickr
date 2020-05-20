package com.example.apiflickr.domain

import com.example.apiflickr.domain.photo.PhotoEntity

data class Page(
    val page: Int,
    val pages: Int,
    val perPage: Int,
    val photo: List<PhotoEntity>
)
