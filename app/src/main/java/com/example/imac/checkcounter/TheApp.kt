package com.example.imac.checkcounter

import android.app.Application
import com.example.imac.checkcounter.di.appModule
import org.koin.android.ext.android.startKoin

class TheApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(appModule))
    }
}