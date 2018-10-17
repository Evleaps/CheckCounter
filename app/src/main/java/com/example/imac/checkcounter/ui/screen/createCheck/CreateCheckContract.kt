package com.example.imac.checkcounter.ui.screen.createCheck

import com.example.imac.checkcounter.data.model.entity.Check

interface CreateCheckContract {
    interface View {
        fun updateList(list: List<Check>)
    }
    interface Presenter {
        fun onSend(name: String, total: Int)
        fun loadAllChecks()
        fun onBack()
        fun getCheckList(): List<Check>
    }
}