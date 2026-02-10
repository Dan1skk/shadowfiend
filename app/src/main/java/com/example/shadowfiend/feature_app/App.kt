package com.example.shadowfiend.feature_app

import android.app.Application
import com.example.shadowfiend.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(ViewModelModule,))
        }
    }
}