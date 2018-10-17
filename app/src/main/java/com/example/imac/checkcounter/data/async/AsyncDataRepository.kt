package com.example.imac.checkcounter.data.async

import com.example.imac.checkcounter.data.AppDatabase
import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AsyncDataRepository : IAsyncRepository {

    override fun insertCheck(check: Check) {
        val db = AppDatabase.getInstance()?.getCheckDao()
        Completable.fromAction { }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }

    override fun getCheckList(): Single<List<Check>> {
        val db = AppDatabase.getInstance()?.getCheckDao()
        val data = db?.getCheckList()

        return data ?: Single.amb(emptyList())
    }

}