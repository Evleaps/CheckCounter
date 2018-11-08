package com.example.imac.checkcounter.ui.screen.checkList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.data.model.entity.Check
import com.example.imac.checkcounter.ui.screen.adapter.CheckListAdapter
import kotlinx.android.synthetic.main.fragment_check_list.view.*
import org.koin.android.ext.android.inject


class CheckListFragment : Fragment(), CheckListContract.View {

    companion object {
        @JvmStatic val TAG = "TAG"
    }

    private lateinit var recyclerView: RecyclerView
    private val presenter: CheckListPresenter by inject()
    private val adapter = CheckListAdapter(emptyList()){}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_check_list, container, false)

        recyclerView = rootView.findViewById(R.id.checkList_recyclerList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        presenter.loadChecks()

        rootView.createCheck.setOnClickListener {
            presenter.addCheck()
        }

        return rootView
    }


    override fun updateCheckList(checks: List<Check>) {
        adapter.updateList(checks)
    }

}