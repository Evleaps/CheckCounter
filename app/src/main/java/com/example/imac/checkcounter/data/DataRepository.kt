package com.example.imac.checkcounter.data

import com.example.imac.checkcounter.data.async.IAsyncRepository
import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Single

class DataRepository(private val asyncRepository: IAsyncRepository) : IRepository {


    override fun saveCheck(check: Check) {
        asyncRepository.insertCheck(check)
    }

    override fun getChecks(): Single<List<Check>> = asyncRepository.getCheckList()


}