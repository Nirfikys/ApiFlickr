package com.example.apiflickr.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.apiflickr.databinding.PhotoInfoLayoutBinding
import com.example.apiflickr.domain.photo.PhotoInfoEntity
import com.example.apiflickr.ui.core.BaseFragment

class PhotoInfoFragment : BaseFragment() {
    lateinit var binding: PhotoInfoLayoutBinding
    lateinit var photo: PhotoInfoEntity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PhotoInfoLayoutBinding.inflate(inflater, container, false)
        val safeArgs: PhotoInfoFragmentArgs by navArgs()
        binding.photo = safeArgs.photoInfo
        return binding.root
    }
}