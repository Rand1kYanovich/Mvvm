package com.example.testmvvm.smartsport

import android.app.Application
import com.example.testmvvm.smartsport.di.module.module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(listOf(module)
            )
        }
    }
}