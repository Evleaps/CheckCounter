package com.example.imac.checkcounter.ui.screen.checkList

interface CheckListContract {

    interface View {
        fun showList()
    }

    interface Presenter {
        fun getList()
        fun addCheck()
        fun deleteCheck()
        fun updateCheck()
    }
}