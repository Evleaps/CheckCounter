package com.example.imac.checkcounter.data

import com.example.imac.checkcounter.data.async.IAsyncRepository
import com.example.imac.checkcounter.data.model.entity.Check

class DataRepository(private val asyncRepository: IAsyncRepository) : IRepository {


    override fun saveCheck(check: Check) {
        asyncRepository.insertCheck(check)
    }

    override fun getChecks(): List<Check> = asyncRepository.getCheckList()


}