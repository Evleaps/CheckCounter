package com.example.imac.checkcounter.ui.screen.createCheck

import com.example.imac.checkcounter.data.DataRepository
import com.example.imac.checkcounter.data.IRepository
import com.example.imac.checkcounter.data.async.AsyncDataRepository
import com.example.imac.checkcounter.data.model.entity.Check
import java.text.SimpleDateFormat
import java.util.*

class CreateCheckPresenter : CreateCheckContract.Presenter {

    private val repository = DataRepository(AsyncDataRepository())

    override fun onSend(total: Int, name: String) {
        val format = SimpleDateFormat("dd:MM:yyyy", Locale.getDefault())
        val currentDate = format.format(Date())
        repository.saveCheck(Check(null, total, name, currentDate))
    }

    override fun getCheckList(): List<Check> = repository.getChecks()

}