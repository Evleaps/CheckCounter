package com.example.imac.checkcounter.core.adapter

import android.support.annotation.CallSuper
import android.support.v7.widget.RecyclerView
import android.view.View

class BaseHolder(view: View) : RecyclerView.ViewHolder(view) {
    protected lateinit var data: IItemType

    @CallSuper
    open fun bind(item: IItemType) {
        data = item
    }

    @CallSuper
    fun setOnItemClickListener(listener: IItemClickListener) {
        itemView.setOnClickListener { listener.onItemClicked(data) }
    }

    @CallSuper
    fun setOnItemLongClickListener(listener: IItemClickListener) {
        itemView.setOnLongClickListener {
            listener.onItemLongClicked(data)
            return@setOnLongClickListener true
        }
    }
}
