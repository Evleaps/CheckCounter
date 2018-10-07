package com.example.imac.checkcounter.ui.di

import com.example.imac.checkcounter.ui.screen.baseFragment.BaseFragment
import com.example.imac.checkcounter.ui.screen.splash.SplashActivity
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component (modules = arrayOf(Module::class))
interface Component : AndroidInjector<SplashActivity>{
}