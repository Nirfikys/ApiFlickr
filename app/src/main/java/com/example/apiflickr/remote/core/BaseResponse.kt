package com.example.apiflickr.remote.core

import com.google.gson.annotations.SerializedName


open class BaseResponse(
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("stat")
    val stat: String? = null
)