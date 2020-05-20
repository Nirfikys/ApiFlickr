package com.example.apiflickr.remote.core

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class NetworkHandler @Inject constructor(val context: Context) {

    var isConnected: Boolean = true
}