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


class CheckListFragment : Fragment(), CheckListContract.View {

    companion object {
        @JvmStatic val TAG = "TAG"
    }

    private lateinit var recyclerView: RecyclerView
    private val presenter = CheckListPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_check_list, container, false)
        val check1 = Check(null,"5000", "check1", "12:2:2012")
        val check2 = Check(null,"6000", "check2", "12:2:2013")
        val check3 = Check(null,"7000", "check3", "12:2:2014")

        recyclerView = rootView.findViewById(R.id.checkList_recyclerList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = CheckListAdapter(listOf(check1, check2, check3)) {
            presenter.addCheck()
        }

        return rootView
    }





    override fun showList() {
        TODO("not implemented") //To

    }


}