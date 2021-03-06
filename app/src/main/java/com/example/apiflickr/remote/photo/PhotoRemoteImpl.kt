package com.example.apiflickr.remote.photo

import com.example.apiflickr.domain.Page
import com.example.apiflickr.domain.photo.PhotoInfoEntity
import com.example.apiflickr.domain.photo.PhotoRemote
import com.example.apiflickr.domain.toEntity
import com.example.apiflickr.remote.core.Request
import com.example.apiflickr.remote.service.ApiService
import com.example.apiflickr.remote.service.ServiceFactory
import javax.inject.Inject

class PhotoRemoteImpl @Inject constructor(
    private val request: Request,
    private val api: ApiService
) : PhotoRemote {
    override fun searchPhotos(text: String, page: Int): Page {
        return request.make(api.searchPhoto(ServiceFactory.API_KEY, text, page)){
            it.photos.toEntity()
        }
    }

    override fun getPhotoInfo(id: String): PhotoInfoEntity {
        return request.make(api.getPhotoInfo(ServiceFactory.API_KEY, id)) {
            it.toEntity()
        }
    }
}