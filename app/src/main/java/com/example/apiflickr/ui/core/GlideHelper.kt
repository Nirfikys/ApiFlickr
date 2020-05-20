package com.example.apiflickr.ui.core

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.apiflickr.R

object GlideHelper {

    fun loadImage(context: Context, path: String?, iv: ImageView) {
        if (path.isNullOrBlank()){
            Glide.with(context).load(R.drawable.ic_error_black_48dp).into(iv)
            return
        }

        Glide.with(context)
            .load(path)
            .error(R.drawable.ic_error_black_48dp)
            .into(iv)
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(image: String?) {
        loadImage(this.context, image, this)
    }
}