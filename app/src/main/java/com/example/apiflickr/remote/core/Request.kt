package com.example.apiflickr.remote.core

import com.example.apiflickr.domain.Failure
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Request @Inject constructor(
    private val networkHandler: NetworkHandler
) {

    fun <T : BaseResponse, R> make(call: Call<T>, transform: (T) -> R): R {
        return when (networkHandler.isConnected) {
            true -> execute(call, transform)
            false -> throw Failure.NetworkConnectionError
        }
    }

    private fun <T : BaseResponse, R> execute(call: Call<T>, transform: (T) -> R): R {
        return try {
            val response = call.execute()
            when (response.isSucceed()) {
                true -> transform((response.body()!!))
                false -> {
                    throw Exception(response.body()?.message)
                }
            }
        } catch (e: Exception) {
            throw Failure.ServerError
        }
    }

    private fun <T : BaseResponse> Response<T>.isSucceed(): Boolean {
        return isSuccessful && body() != null
    }
}