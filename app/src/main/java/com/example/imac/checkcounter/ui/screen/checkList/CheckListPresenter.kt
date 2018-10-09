package com.example.imac.checkcounter.ui.screen.checkList

import com.example.imac.checkcounter.ui.router.Router

class CheckListPresenter : CheckListContract.Presenter {

    private var router: Router = Router.getInstance(null)

    override fun getList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addCheck() {
        router.replace(Router.CREATE_CHECK)
    }

    override fun deleteCheck() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCheck() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}