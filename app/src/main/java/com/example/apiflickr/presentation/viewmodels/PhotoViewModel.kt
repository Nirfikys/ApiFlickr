package com.example.apiflickr.presentation.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import com.example.apiflickr.domain.Page
import com.example.apiflickr.domain.photo.PhotoInfoEntity
import com.example.apiflickr.domain.photo.PhotoRepository
import com.example.apiflickr.presentation.core.HandleOnce
import com.example.apiflickr.ui.App
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotoViewModel : BaseViewModel() {
    init {
        App.appComponent.inject(this)
        getPreview()
    }

    @Inject
    lateinit var photoRepository: PhotoRepository

    val pagePhotoData = MutableLiveData<Page>()
    val photoInfoData = MutableLiveData<HandleOnce<PhotoInfoEntity>>()
    var page = 1
        set(value) {
            if (value <= 0) return
            field = value
            getPreview()
        }

    @SuppressLint("CheckResult")
    fun searchPhoto(text: String) {
        Observable.create<Page> {
            it.onNext(photoRepository.searchPhotos(text, page))
            it.onComplete()
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ handleValidResult(pagePhotoData, it) }, { handleFailure(it) })
    }

    @SuppressLint("CheckResult")
    fun getPhotoInfo(id: String) {
        Observable.create<PhotoInfoEntity> {
            it.onNext(photoRepository.getPhotoInfo(id))
            it.onComplete()
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ handleValidResult(photoInfoData, HandleOnce(it)) }, { handleFailure(it) })
    }

    fun getPreview() {
        searchPhoto("cat")
    }
}