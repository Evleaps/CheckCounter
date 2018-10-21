package com.example.imac.checkcounter.data.async

import com.example.imac.checkcounter.data.AppDatabase
import com.example.imac.checkcounter.data.model.entity.Check

class AsyncDataRepository : IAsyncRepository {

    override fun insertCheck(check: Check) {
        val db = AppDatabase.getInstance()?.getCheckDao()
        db?.insertCheck(check)
    }

    override fun getCheckList(): List<Check> {
        val db = AppDatabase.getInstance()?.getCheckDao()
        return db?.getCheckList()
    }


}