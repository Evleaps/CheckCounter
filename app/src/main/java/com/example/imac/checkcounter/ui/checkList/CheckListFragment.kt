package com.example.imac.checkcounter.ui.checkList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.checkcounter.R

class CheckListFragment : Fragment(), CheckListContract.View {

    companion object {
        const val TAG = "TAG"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.check_list_fragment, container, false)


    override fun showList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}