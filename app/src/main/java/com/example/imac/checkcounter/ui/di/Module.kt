package com.example.imac.checkcounter.ui.di


import android.support.v4.app.FragmentManager
import com.example.imac.checkcounter.ui.router.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class Module(private val fragmentManager: FragmentManager) {

    @Provides
    @Singleton
    fun getRouter(): Router = Router(fragmentManager)

}