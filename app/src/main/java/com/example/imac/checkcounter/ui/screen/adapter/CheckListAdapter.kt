package com.example.imac.checkcounter.ui.screen.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.data.model.entity.Check
import kotlinx.android.synthetic.main.adapter_check_list.view.*

internal class CheckListAdapter(private val checkList: List<Check>,
                                private val onClick: () -> Unit) : RecyclerView.Adapter<CheckListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_check_list, parent, false)

        v.findViewById<LinearLayout>(R.id.checkListBtn).setOnClickListener { onClick() }

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return checkList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(checkList[position])
    }


    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item: Check) {
            itemView.adapterCheckDate.text = item.date
            itemView.adapterTotal.text = item.total
        }
    }
}