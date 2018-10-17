package com.example.imac.checkcounter.data

import com.example.imac.checkcounter.data.model.entity.Check

interface IRepository {
    fun getChecks(): List<Check>
    fun saveCheck(check: Check)
}