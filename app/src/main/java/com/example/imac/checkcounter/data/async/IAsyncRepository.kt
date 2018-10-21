package com.example.imac.checkcounter.data.async

import com.example.imac.checkcounter.data.model.entity.Check

interface IAsyncRepository {

    fun getCheckList(): List<Check>

    fun insertCheck(check: Check)
}