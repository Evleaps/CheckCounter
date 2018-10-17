package com.example.imac.checkcounter.ui.screen.createCheck

import com.example.imac.checkcounter.data.model.entity.Check

interface CreateCheckContract {
    interface View {
        fun updateList()
    }
    interface Presenter {
        fun onSend(total: Int, name: String)
        fun getCheckList(): List<Check>
    }
}