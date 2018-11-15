package com.example.imac.checkcounter.ui.screen.createCheck


import com.example.imac.checkcounter.core.presentation.BasePresenter
import com.example.imac.checkcounter.data.DataRepository
import com.example.imac.checkcounter.data.model.entity.Check
import com.example.imac.checkcounter.data.model.entity.CheckItem
import com.example.imac.checkcounter.ui.router.Router
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CreateCheckPresenter(private val repository: DataRepository) : BasePresenter<CreateCheckContract.View>(),CreateCheckContract.Presenter {

    private var itemsList = ArrayList<CheckItem>()
    private var router: Router = Router.getInstance(null)

    override fun onSave(name: String) {
        repository.saveCheck(Check(null, getTotal(), name, getCurrentDate(), itemsList))
        router.back()
    }

    override fun onAddItem(total: Int, name: String) {
        itemsList.add(CheckItem(total, name))
        view?.updateList(itemsList.toList())
    }

    override fun getCheckItemsList(): List<CheckItem> = itemsList.toList()

    private fun getTotal() : Int = itemsList.sumBy { it.cost }

    private fun getCurrentDate() : String = SimpleDateFormat("dd:MM:yyyy", Locale.getDefault()).format(Date())

}