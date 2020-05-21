package com.example.apiflickr.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apiflickr.databinding.HomeLayoutBinding
import com.example.apiflickr.presentation.viewmodels.PhotoViewModel
import com.example.apiflickr.ui.adapters.PhotoAdapter
import com.example.apiflickr.ui.core.observe

class HomeFragment : Fragment() {

    private lateinit var binding: HomeLayoutBinding
    private lateinit var photoModel: PhotoViewModel
    private val adapter = PhotoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoModel =
            ViewModelProvider(this.activity as AppCompatActivity).get(PhotoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeLayoutBinding.inflate(inflater, container, false)
        setupView()
        return binding.root
    }

    private fun setupView() {
        binding.searchButton.setOnClickListener {
            val text = binding.searchEt.text.toString()
            if (!text.isBlank())
                photoModel.searchPhoto(
                    text
                )
        }
        binding.pageIndicatorNext.setOnClickListener { photoModel.page += 1 }
        binding.pageIndicatorPrev.setOnClickListener { photoModel.page -= 1 }

        binding.photoRv.layoutManager = GridLayoutManager(context, 3)
        binding.photoRv.adapter = adapter
        adapter.setOnClick({ photo, _ ->
            if (photo == null) return@setOnClick
            photoModel.getPhotoInfo(photo.id)
        })

        observe(photoModel.pagePhotoData) {
            binding.currentPage = it.page
            binding.maxPage = it.pages
            binding.invalidateAll()
            adapter.changeAdapterData(it.photo)
        }

        observe(photoModel.photoInfoData) {
            val photo = it.getContentIfNotHandled() ?: return@observe
            val direction = HomeFragmentDirections.actionMainFragmentToPhotoInfoFragment(photo)
            findNavController().navigate(direction)
        }
    }
}