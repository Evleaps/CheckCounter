package com.example.imac.checkcounter.ui.screen.createCheck

import com.example.imac.checkcounter.data.model.entity.CheckItems

interface CreateCheckContract {
    interface View {
        fun updateList(list: List<CheckItems>)
    }
    interface Presenter {
        fun onSave(name: String)
        fun onAddItem(total: Int, name: String)
        fun getCheckItemsList(): List<CheckItems>
    }
}