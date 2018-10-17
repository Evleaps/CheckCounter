package com.example.imac.checkcounter.ui.screen.createCheck

import android.util.Log
import com.example.imac.checkcounter.data.DataRepository
import com.example.imac.checkcounter.data.async.AsyncDataRepository
import com.example.imac.checkcounter.data.model.entity.Check
import com.example.imac.checkcounter.ui.router.Router
import com.example.imac.checkcounter.ui.screen.checkList.CheckListContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

class CreateCheckPresenter(private var view: CreateCheckFragment?) : CreateCheckContract.Presenter {

    private var router: Router = Router.getInstance(null)
    private val repository = DataRepository(AsyncDataRepository())
    private var check = emptyList<Check>()

    override fun onSend(name: String, total: Int) {
        val format = SimpleDateFormat("dd:MM:yyyy", Locale.getDefault())
        val currentDate = format.format(Date())
        repository.saveCheck(Check(null, total, name, currentDate))
        loadAllChecks()
    }

    override fun loadAllChecks() {
        repository.getChecks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d("ROMA", "it: $it")
                    check = it
                    view?.updateList(check)
                }) {}
    }

    override fun onBack() {
        router.back()
    }

    override fun getCheckList(): List<Check> = check
}