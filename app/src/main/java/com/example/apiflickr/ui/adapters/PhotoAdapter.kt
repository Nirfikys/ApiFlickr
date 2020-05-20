package com.example.apiflickr.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.apiflickr.databinding.PhotoItemBinding
import com.example.apiflickr.domain.photo.PhotoEntity
import com.example.apiflickr.ui.core.BaseAdapter

class PhotoAdapter : BaseAdapter<PhotoViewHolder, PhotoEntity>() {
    override fun areContentsTheSame(oldItem: PhotoEntity, newItem: PhotoEntity): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: PhotoEntity, newItem: PhotoEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun createHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PhotoViewHolder(
            PhotoItemBinding.inflate(inflater, parent, false)
        )
    }

}

class PhotoViewHolder(private val binding: PhotoItemBinding) :
    BaseAdapter.BaseViewHolder<PhotoEntity>(binding.root) {
    override fun onBind(item: PhotoEntity) {
        binding.photo = item
    }

}