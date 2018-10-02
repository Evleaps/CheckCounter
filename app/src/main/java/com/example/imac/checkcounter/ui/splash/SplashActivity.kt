package com.example.imac.checkcounter.ui.splash

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.ui.checkList.CheckListFragment

class SplashActivity : AppCompatActivity() {

    private var checkList = CheckListFragment()
    private var manager = supportFragmentManager
    private lateinit var transation: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        transation = manager.beginTransaction()
        if (manager.findFragmentByTag(CheckListFragment.TAG) == null) {
            transation.add(R.id.splash_container, checkList, CheckListFragment.TAG)
        }
    }
}
