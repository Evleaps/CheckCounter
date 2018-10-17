package com.example.imac.checkcounter.ui.screen.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.data.model.entity.Check
import kotlinx.android.synthetic.main.adapter_create_check.view.*

internal class CreateCheckAdapter(private val checkList: List<Check>) : RecyclerView.Adapter<CreateCheckAdapter.ViewHolder>() {

    private var items: List<Check> = checkList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_create_check, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return checkList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(checkList[position])
    }

    fun items(list: List<Check>) {
        items = list
        notifyDataSetChanged()
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Check) {
            itemView.createCheck_position.text = item.name
            itemView.createCheck_price.text = item.total.toString()
        }
    }
}