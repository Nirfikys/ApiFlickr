package com.example.apiflickr.domain.photo

import com.example.apiflickr.domain.Page
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val remote: PhotoRemote
) : PhotoRepository {
    override fun searchPhotos(text: String, page: Int): Page {
        return remote.searchPhotos(text, page)
    }
}