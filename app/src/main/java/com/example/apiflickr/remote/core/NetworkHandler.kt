package com.example.apiflickr.remote.core

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class NetworkHandler @Inject constructor(val context: Context) {

    companion object {
        val connectionCallbackList = ArrayList<(network: Network) -> Unit>()
    }

    init {
        registerDefaultNetworkCallback()
    }

    var isConnected: Boolean = false

    private fun registerDefaultNetworkCallback() {
        val cm = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
        cm.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                isConnected = true
                connectionCallbackList.forEach { it(network) }
                connectionCallbackList.clear()
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                isConnected = false
            }
        })
    }
}