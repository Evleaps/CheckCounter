package com.example.imac.checkcounter.ui.screen.checkList

import com.example.imac.checkcounter.core.presentation.IBasePresenter
import com.example.imac.checkcounter.core.presentation.IBaseView
import com.example.imac.checkcounter.data.model.entity.Check

interface CheckListContract {

    interface View : IBaseView {
        fun updateCheckList(checks: List<Check>)
    }

    interface Presenter : IBasePresenter {
        fun loadChecks()
        fun addCheck()
        fun deleteCheck()
        fun updateCheck()
    }
}