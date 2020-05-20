package com.example.apiflickr

import android.content.Context
import com.example.apiflickr.remote.core.NetworkHandler
import com.example.apiflickr.remote.core.Request
import com.example.apiflickr.remote.photo.PhotoRemoteImpl
import com.example.apiflickr.remote.service.ServiceFactory
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val key = "11e385a385f88dd2d5cc8ec6d40f0222"
        val text = "cat"
        //ServiceFactory.makeService(true).searchPhoto(key, text).execute()
        val api = ServiceFactory.makeService(true)
        val context = mock(Context::class.java)
        val remote = PhotoRemoteImpl(Request(NetworkHandler(context)), api)
        remote.searchPhotos(text)
    }
}
