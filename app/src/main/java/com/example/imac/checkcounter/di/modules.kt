package com.example.imac.checkcounter.di

import android.arch.persistence.room.Room
import com.example.imac.checkcounter.data.AppDatabase
import com.example.imac.checkcounter.data.DATABASE_NAME
import com.example.imac.checkcounter.data.DataRepository
import com.example.imac.checkcounter.data.async.AsyncDataRepository
import com.example.imac.checkcounter.ui.screen.checkList.CheckListPresenter
import com.example.imac.checkcounter.ui.screen.createCheck.CreateCheckPresenter
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val appModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DATABASE_NAME)
                .build()
    }

    single { get<AppDatabase>().getCheckDao() }

    single { AsyncDataRepository(get()) }

    single { DataRepository(get()) }

    single { CheckListPresenter(get()) }

    single { CreateCheckPresenter(get()) }
}