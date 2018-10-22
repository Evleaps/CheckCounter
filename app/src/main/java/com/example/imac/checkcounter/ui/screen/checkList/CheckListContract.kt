package com.example.imac.checkcounter.ui.screen.checkList

import com.example.imac.checkcounter.data.model.entity.Check

interface CheckListContract {

    interface View {
        fun updateCheckList(checks: List<Check>)
    }

    interface Presenter {
        fun loadChecks()
        fun addCheck()
        fun deleteCheck()
        fun updateCheck()
    }
}