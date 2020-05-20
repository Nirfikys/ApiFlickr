package com.example.apiflickr.presentation.modules

import com.example.apiflickr.domain.photo.PhotoRemote
import com.example.apiflickr.remote.core.Request
import com.example.apiflickr.remote.photo.PhotoRemoteImpl
import com.example.apiflickr.remote.service.ApiService
import com.example.apiflickr.remote.service.ServiceFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {
    @Singleton
    @Provides
    fun provideApiService(): ApiService = ServiceFactory.makeService(false)


    @Singleton
    @Provides
    fun provideMovieRemote(request: Request, apiService: ApiService): PhotoRemote {
        return PhotoRemoteImpl(request, apiService)
    }
}