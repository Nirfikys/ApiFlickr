package com.example.apiflickr.domain

import com.example.apiflickr.domain.photo.PhotoEntity
import com.example.apiflickr.domain.photo.PhotoInfoEntity
import com.example.apiflickr.remote.photo.PageResponse
import com.example.apiflickr.remote.photo.PhotoInfoResponse
import com.example.apiflickr.remote.photo.SearchPhotoInfo
import java.util.*

fun PageResponse.toEntity(): Page {
    return Page(
        page,
        pages,
        perpage,
        photo.map { it.toEntity() }
    )
}

fun SearchPhotoInfo.toEntity(): PhotoEntity {
    return PhotoEntity(
        id,
        "https://farm${farm}.staticflickr.com/${server}/${id}_${secret}.jpg",
        title
    )
}

fun PhotoInfoResponse.toEntity(): PhotoInfoEntity {
    photo.apply {
        return PhotoInfoEntity(
            id,
            title.content,
            "https://farm${farm}.staticflickr.com/${server}/${id}_${secret}.jpg",
            Date(dates.posted.toLong()),
            comments.content
        )
    }
}

