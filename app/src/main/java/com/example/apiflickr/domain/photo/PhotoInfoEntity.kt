package com.example.apiflickr.domain.photo

import java.io.Serializable
import java.util.*

data class PhotoInfoEntity(
    val id: String,
    val title: String,
    val url: String,
    val posted: Date,
    val comments:Int
):Serializable
