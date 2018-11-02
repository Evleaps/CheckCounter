package com.example.imac.checkcounter.ui.screen.createCheck


import android.util.Log
import com.example.imac.checkcounter.data.DataRepository
import com.example.imac.checkcounter.data.async.AsyncDataRepository
import com.example.imac.checkcounter.data.model.entity.Check
import com.example.imac.checkcounter.data.model.entity.CheckItems
import com.example.imac.checkcounter.ui.router.Router
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CreateCheckPresenter(private val view: CreateCheckFragment?) : CreateCheckContract.Presenter {

    private val repository = DataRepository(AsyncDataRepository())
    private var itemsList = ArrayList<CheckItems>()
    private var router: Router = Router.getInstance(null)

    override fun onSave(name: String) {
        repository.saveCheck(Check(null, getTotal(), name, getCurrentDate()))
        router.back()
    }

    override fun onAddItem(total: Int, name: String) {
        itemsList.add(CheckItems(total, name))
        Log.d("ROMAN", "itemsList.toList(): ${itemsList.toList()}")
        view?.updateList(itemsList.toList())
    }

    override fun getCheckItemsList(): List<CheckItems> = itemsList.toList()

    private fun getTotal() : Int = itemsList.sumBy { it.cost }

    private fun getCurrentDate() : String = SimpleDateFormat("dd:MM:yyyy", Locale.getDefault()).format(Date())

}