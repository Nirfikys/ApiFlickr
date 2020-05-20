package com.example.apiflickr.presentation.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.apiflickr.domain.Page
import com.example.apiflickr.domain.photo.PhotoRepository
import com.example.apiflickr.ui.App
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotoViewModel : BaseViewModel() {
    init {
        App.appComponent.inject(this)
    }

    @Inject
    lateinit var photoRepository: PhotoRepository

    val pagePhotoData = MutableLiveData<Page>()
    var page = 1
        set(value) {
            if (value <= 0) return
            field = value
            getPreview()
        }

    @SuppressLint("CheckResult")
    fun getPreview() {
        Observable.create<Page> {
            it.onNext(photoRepository.searchPhotos("cat"))
            it.onComplete()
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ handleValidResult(pagePhotoData, it) }, { handleFailure(it) })
    }
}