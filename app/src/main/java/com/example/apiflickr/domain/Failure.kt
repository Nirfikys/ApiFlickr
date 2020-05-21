package com.example.apiflickr.domain

import java.lang.Exception

sealed class Failure : Exception() {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
}