package com.example.apiflickr.ui.core

import android.content.Context
import com.example.apiflickr.R
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    @JvmStatic
    fun formatPosted(context: Context, date: Date): String {
        return context.getString(R.string.posted) + " " + SimpleDateFormat("dd.MM.YYYY").format(date)
    }
}