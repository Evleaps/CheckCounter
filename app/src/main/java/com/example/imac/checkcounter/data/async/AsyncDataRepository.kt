package com.example.imac.checkcounter.data.async

import com.example.imac.checkcounter.data.AppDatabase
import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class AsyncDataRepository(private val db: AppDatabase) : IAsyncRepository {

    override fun insertCheck(check: Check) {
        Observable.just(db)
                .subscribeOn(Schedulers.io())
                .subscribe { it.getCheckDao().insertCheck(check) }
    }

    override fun getCheck(): Single<Check> {
        return db.getCheckDao().getCheck()
    }

    override fun getCheckList(): Single<List<Check>> {
        return db.getCheckDao().getCheckList()
    }

}