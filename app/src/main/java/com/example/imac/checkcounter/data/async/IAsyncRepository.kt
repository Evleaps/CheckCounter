package com.example.imac.checkcounter.data.async

import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Single

interface IAsyncRepository {

    fun getCheckList(): Single<List<Check>>

    fun insertCheck(check: Check)
}