package com.example.imac.checkcounter.ui.screen.createCheck

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.common.LOG_PREFIX
import com.example.imac.checkcounter.core.presentation.BaseFragment
import com.example.imac.checkcounter.data.model.entity.CheckItem
import com.example.imac.checkcounter.ui.screen.adapter.CreateCheckAdapter
import kotlinx.android.synthetic.main.fragment_create_check.*
import kotlinx.android.synthetic.main.fragment_create_check.view.*
import org.koin.android.ext.android.inject

class CreateCheckFragment : BaseFragment<CreateCheckContract.Presenter>(), CreateCheckContract.View {

    companion object {
        @JvmStatic val TAG = LOG_PREFIX + CreateCheckFragment::class.java.simpleName
    }

    private lateinit var recyclerView: RecyclerView
    override val presenter: CreateCheckPresenter by inject()
    private val adapter = CreateCheckAdapter(emptyList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_create_check, container, false)

        recyclerView = rootView.findViewById(R.id.createCheck_recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        rootView.createCheckSend.setOnClickListener {
            presenter.onSave(createCheckName.text.toString())
        }

        rootView.addItemCheck.setOnClickListener {
            if (createCheckTotal.text.toString().isNotEmpty() && createCheckNewPosition.text.toString().isNotEmpty()) {
                presenter.onAddItem(createCheckTotal.text.toString().toInt(), createCheckNewPosition.text.toString())
                createCheckTotal.text = null
                createCheckNewPosition.text = null
                createCheckName.text = null
                createCheckNewPosition.requestFocus()
            }
        }

        return rootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (presenter.getCheckItemsList().isNotEmpty()) {
            presenter.onSave(createCheckName.text.toString())
        }
    }

    override fun updateList(list: List<CheckItem>) {
        adapter.updateList(list)
    }

}