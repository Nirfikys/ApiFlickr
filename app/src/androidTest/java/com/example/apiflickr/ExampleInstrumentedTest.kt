package com.example.apiflickr

import android.content.Context
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.apiflickr.cache.PhotoCacheImpl
import com.example.apiflickr.cache.PhotoDatabase
import com.example.apiflickr.remote.core.NetworkHandler
import com.example.apiflickr.remote.core.Request
import com.example.apiflickr.remote.photo.PhotoRemoteImpl
import com.example.apiflickr.remote.service.ServiceFactory

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.mockito.Mockito

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val key = "11e385a385f88dd2d5cc8ec6d40f0222"
        val text = "cat"
        //ServiceFactory.makeService(true).searchPhoto(key, text).execute()
        val api = ServiceFactory.makeService(true)
        val remote = PhotoRemoteImpl(Request(NetworkHandler(appContext)), api)
        val remotePhoto = remote.searchPhotos(text)
        val database = Room.inMemoryDatabaseBuilder(appContext, PhotoDatabase::class.java).build()
        val cache = PhotoCacheImpl(database.photoDao)
        cache.savePhotosPreview(remotePhoto.photo)
        cache.searchPhotos(text)
    }
}
