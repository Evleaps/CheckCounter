package com.example.imac.checkcounter.ui.screen.createCheck

import com.example.imac.checkcounter.data.model.entity.CheckItem

interface CreateCheckContract {
    interface View {
        fun updateList(list: List<CheckItem>)
    }
    interface Presenter {
        fun onSave(name: String)
        fun onAddItem(total: Int, name: String)
        fun getCheckItemsList(): List<CheckItem>
    }
}