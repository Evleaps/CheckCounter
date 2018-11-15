package com.example.imac.checkcounter.data.repository

import com.example.imac.checkcounter.data.repository.async.IAsyncRepository
import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Single

class DataRepository(private val asyncRepository: IAsyncRepository) : IRepository {

    override fun saveCheck(check: Check) {
        asyncRepository.insertCheck(check)
    }

    override fun getAllChecks(): Single<List<Check>> = asyncRepository.getCheckList()

    override fun getCheck(): Single<Check> = asyncRepository.getCheck()
}