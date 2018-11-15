package com.example.imac.checkcounter.ui.screen.createCheck

import com.example.imac.checkcounter.core.presentation.IBasePresenter
import com.example.imac.checkcounter.core.presentation.IBaseView
import com.example.imac.checkcounter.data.model.entity.CheckItem

interface CreateCheckContract {
    interface View: IBaseView {
        fun updateList(list: List<CheckItem>)
    }
    interface Presenter: IBasePresenter {
        fun onSave(name: String)
        fun onAddItem(total: Int, name: String)
        fun getCheckItemsList(): List<CheckItem>
    }
}