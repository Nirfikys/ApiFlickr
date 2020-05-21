package com.example.apiflickr.domain.photo

import com.example.apiflickr.domain.Page
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val remote: PhotoRemote,
    private val cache: PhotoCache
) : PhotoRepository {
    override fun searchPhotos(text: String, page: Int): Page {
        return remote.searchPhotos(text, page)
    }

    override fun savePreviewPhotos(photos: List<PhotoEntity>) {
        cache.savePhotosPreview(photos)
    }

    override fun searchSavedPhotos(text: String): Page {
        return cache.searchPhotos(text)
    }

    override fun getPhotoInfo(id: String): PhotoInfoEntity {
        return remote.getPhotoInfo(id)
    }

    override fun getSavedPhotoInfo(id: String): PhotoInfoEntity? {
        return cache.getPhotoInfo(id)
    }

    override fun savePhotoInfo(photoInfo: PhotoInfoEntity) {
        cache.savePhotosInfo(listOf(photoInfo))
    }
}