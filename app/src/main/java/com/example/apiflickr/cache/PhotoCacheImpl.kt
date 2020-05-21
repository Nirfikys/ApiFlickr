package com.example.apiflickr.cache

import com.example.apiflickr.domain.Page
import com.example.apiflickr.domain.photo.PhotoCache
import com.example.apiflickr.domain.photo.PhotoEntity
import com.example.apiflickr.domain.photo.PhotoInfoEntity
import com.example.apiflickr.domain.toCache
import com.example.apiflickr.domain.toEntity

class PhotoCacheImpl(
    private val photoDao: PhotoDao
) : PhotoCache {
    override fun savePhotosInfo(photos: List<PhotoInfoEntity>) {
        photos.forEach { photoDao.savePhotoInfo(it.toCache()) }
    }

    override fun savePhotosPreview(photos: List<PhotoEntity>) {
        photos.map { it.toCache() }
    }

    override fun searchPhotos(text: String, page: Int): Page {
        val photos = photoDao.searchPhoto(text).map { it.toEntity() }
        return Page(
            1,
            1,
            100,
            photos
        )
    }

    override fun getPhotoInfo(id: String): PhotoInfoEntity? {
        return photoDao.getPhotoById(id)?.toEntity()
    }
}