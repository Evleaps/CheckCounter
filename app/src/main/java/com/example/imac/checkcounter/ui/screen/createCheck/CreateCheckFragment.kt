package com.example.imac.checkcounter.ui.screen.createCheck

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.data.model.entity.Check
import com.example.imac.checkcounter.ui.screen.adapter.CreateCheckAdapter
import kotlinx.android.synthetic.main.fragment_create_check.*
import kotlinx.android.synthetic.main.fragment_create_check.view.*

class CreateCheckFragment : Fragment(), CreateCheckContract.View {

    companion object {
        @JvmStatic val TAG = "TAG"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CreateCheckAdapter
    private val presenter = CreateCheckPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_create_check, container, false)

        adapter = CreateCheckAdapter(presenter.getCheckList())
        recyclerView = rootView.findViewById(R.id.createCheck_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        rootView.createCheckSend.setOnClickListener {
            presenter.onSend(createCheckNewPosition.text.toString(), createCheckTotal.text.toString().toInt())
            presenter.loadAllChecks()
        }

        return rootView
    }

    override fun updateList(list: List<Check>) {
        adapter.items(list)
    }

}