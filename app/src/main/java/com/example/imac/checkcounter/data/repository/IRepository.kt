package com.example.imac.checkcounter.data.repository

import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Single

interface IRepository {
    fun getAllChecks(): Single<List<Check>>
    fun getCheck(): Single<Check>
    fun saveCheck(check: Check)
}