package com.example.imac.checkcounter.data

import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Single

interface IRepository {
    fun getChecks(): Single<List<Check>>
    fun saveCheck(check: Check)
}