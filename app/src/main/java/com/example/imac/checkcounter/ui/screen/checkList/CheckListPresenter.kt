package com.example.imac.checkcounter.ui.screen.checkList

import com.example.imac.checkcounter.data.DataRepository
import com.example.imac.checkcounter.ui.router.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CheckListPresenter(private val repository: DataRepository) : CheckListContract.Presenter {

    private lateinit var view: CheckListContract.View

    private var router: Router = Router.getInstance(null)

    override fun loadChecks() {
        repository.getAllChecks()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { checkList -> view?.updateCheckList(checkList) }
    }

    override fun addCheck() {
        router.navigateTo(Router.CREATE_CHECK)
    }

    override fun deleteCheck() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCheck() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}