package com.example.imac.checkcounter.ui.screen.createCheck

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.imac.checkcounter.R

class CreateCheckFragment : Fragment() {

    companion object {
        @JvmStatic val TAG = "TAG"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.create_check_fragment, container, false)
}