package com.example.apiflickr.domain

import com.example.apiflickr.cache.PhotoCacheEntity
import com.example.apiflickr.cache.PhotoInfoCacheEntity
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
            Date(dates.posted.toLong() * 1000),
            comments.content
        )
    }
}

fun PhotoInfoEntity.toCache(): PhotoInfoCacheEntity {
    return PhotoInfoCacheEntity(
        id,
        title,
        url,
        posted.time,
        comments
    )
}

fun PhotoEntity.toCache(): PhotoCacheEntity {
    return PhotoCacheEntity(
        id,
        url,
        title
    )
}

fun PhotoInfoCacheEntity.toEntity(): PhotoInfoEntity {
    return PhotoInfoEntity(
        id,
        title,
        url,
        Date(posted),
        comments
    )
}

fun PhotoCacheEntity.toEntity(): PhotoEntity {
    return PhotoEntity(
        id,
        url,
        title
    )
}