package com.example.imac.checkcounter.ui.router


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.ui.screen.checkList.CheckListFragment
import com.example.imac.checkcounter.ui.screen.createCheck.CreateCheckFragment

class Router(private var fragmentManager: FragmentManager) : IRouter {

    companion object {
        const val CHECK_LIST = "checkList"
        const val CREATE_CHECK = "createCheck"
    }

    private var transation: FragmentTransaction = fragmentManager.beginTransaction()

    override fun add(fragmentId: String) {
        val fragm = getFragment(fragmentId)
        if (fragmentManager.findFragmentByTag(fragm.tag) == null) {
            transation.add(R.id.splash_container, fragm, fragm.tag)
        }
        transation.commit()
    }

    override fun replace(fragmentId: String) {
        val fragm = getFragment(fragmentId)
        if (fragmentManager.findFragmentByTag(fragm.tag) == null) {
            transation.replace(R.id.splash_container, fragm, fragm.tag)
        }
        transation.commit()
    }

    override fun remove(fragmentId: String) {
        val fragm = getFragment(fragmentId)
        if (fragmentManager.findFragmentByTag(fragm.tag) != null) {
            transation.remove(fragm)
        }
        transation.commit()
    }

    override fun getTransaction(): FragmentTransaction {
        return transation
    }


    private fun getFragment(fragment: String) : Fragment{
        when(fragment) {
            CHECK_LIST   -> return CheckListFragment()
            CREATE_CHECK -> return CreateCheckFragment()
        }

        return CheckListFragment()
    }
}