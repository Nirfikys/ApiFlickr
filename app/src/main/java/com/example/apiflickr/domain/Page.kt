package com.example.apiflickr.domain

data class Page(
    val page: Int,
    val pages: Int,
    val perPage: Int,
    val photo: List<PhotoEntity>
)
