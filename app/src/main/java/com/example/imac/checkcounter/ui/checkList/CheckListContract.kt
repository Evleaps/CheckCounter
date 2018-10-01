package com.example.imac.checkcounter.ui.checkList

interface CheckListContract {

    interface View {
        fun showList()
    }

    interface Presenter {
        fun getList()
        fun onAddCheck()
        fun deleteCheck()
        fun updateCheck()
    }
}