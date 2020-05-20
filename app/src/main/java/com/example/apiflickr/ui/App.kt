package com.example.apiflickr.ui

import android.app.Application
import com.example.apiflickr.presentation.modules.AppModule
import com.example.apiflickr.presentation.modules.RemoteModule
import com.example.apiflickr.presentation.viewmodels.PhotoViewModel
import dagger.Component
import javax.inject.Singleton

class App : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }
}

@Singleton
@Component(modules = [AppModule::class, RemoteModule::class])
interface AppComponent {

    //activities
    fun inject(activity: MainActivity)

    //fragments
    fun inject(fragment: MainFragment)

    //viewmodel
    fun inject(viewModel: PhotoViewModel)
}