package com.example.imac.checkcounter.ui.screen.checkList

import android.support.v4.app.FragmentManager
import com.example.imac.checkcounter.ui.router.Router

class CheckListPresenter(fragmentManager: FragmentManager) : CheckListContract.Presenter {

    private var router: Router = Router(fragmentManager)

    override fun getList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onAddCheck() {
        router!!.add(Router.CREATE_CHECK)
    }

    override fun deleteCheck() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateCheck() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}