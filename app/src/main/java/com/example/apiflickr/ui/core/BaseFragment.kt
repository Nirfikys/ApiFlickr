package com.example.apiflickr.ui.core

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.apiflickr.R
import com.example.apiflickr.domain.Failure
import java.lang.Exception

abstract class BaseFragment : Fragment() {
    protected open fun showMessageError(error: Throwable) {
        val textError = when (error) {
            is Failure.NetworkConnectionError -> context?.getString(R.string.network_error)
            is Failure.ServerError -> context?.getString(R.string.server_error)
            else -> context?.getString(R.string.other_error)
        }
        Toast.makeText(context, textError, Toast.LENGTH_SHORT).show()
    }
}