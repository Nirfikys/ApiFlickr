package com.example.apiflickr.remote.service

import com.example.apiflickr.remote.photo.PhotosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        //methods
        const val SEARCH = "?method=flickr.photos.search&format=json&nojsoncallback=1"

        //params
        const val PARAM_KEY = "api_key"
        const val PARAM_TEXT = "text"
        const val PARAM_PAGE = "page"
    }

    @GET(SEARCH)
    fun searchPhoto(
        @Query(PARAM_KEY) key: String,
        @Query(PARAM_TEXT) text: String,
        @Query(PARAM_PAGE) page: Int? = null
        ): Call<PhotosResponse>
}