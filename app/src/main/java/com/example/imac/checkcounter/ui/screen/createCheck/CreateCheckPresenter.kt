package com.example.imac.checkcounter.ui.screen.createCheck

import com.example.imac.checkcounter.data.DataRepository
import com.example.imac.checkcounter.data.async.AsyncDataRepository
import com.example.imac.checkcounter.data.model.entity.Check
import com.example.imac.checkcounter.data.model.entity.CheckItems
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

class CreateCheckPresenter(private val view: CreateCheckFragment?) : CreateCheckContract.Presenter {

    private val repository = DataRepository(AsyncDataRepository())
    private var itemsList = emptyArray<CheckItems>()

    override fun onSave() {
        repository.saveCheck(Check(null, total, name, currentDate))
    }

    override fun onAddCheck(total: Int, name: String) {
        itemsList.plus(CheckItems(total, name))
        view?.updateList(itemsList.toList())
    }

    override fun getCheckItemsList(): List<CheckItems> = itemsList.toList()

    private fun getTotal(list: List<CheckItems>) : Int = list.map { it.cost }

    private fun getcurrentDate() : String = SimpleDateFormat("dd:MM:yyyy", Locale.getDefault()).format(Date())

}