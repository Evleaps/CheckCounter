package com.example.imac.checkcounter.data.async

import com.example.imac.checkcounter.data.AppDatabase
import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Observable
import io.reactivex.Single

class AsyncDataRepository : IAsyncRepository {

    override fun insertCheck(check: Check) {
        val db = AppDatabase.getInstance()?.getCheckDao()
        Observable.fromCallable { db?.insertCheck(check) }
    }

    override fun getCheck(): Single<Check> {
        val db = AppDatabase.getInstance()?.getCheckDao()
        return db?.getCheck() ?: Single.amb(emptyList())
    }

    override fun getCheckList(): Single<List<Check>> {
        val db = AppDatabase.getInstance()?.getCheckDao()
        return db?.getCheckList() ?: Single.amb(emptyList())
    }

}