package com.example.apiflickr.domain

import com.example.apiflickr.remote.photo.PageResponse
import com.example.apiflickr.remote.photo.Photo

fun PageResponse.toEntity(): Page {
    return Page(
        page,
        pages,
        perpage,
        photo.map { it.toEntity() }
    )
}

fun Photo.toEntity(): PhotoEntity {
    return PhotoEntity(
        id,
        "https://farm${farm}.staticflickr.com/${server}/${id}_${secret}.jpg",
        title
    )
}