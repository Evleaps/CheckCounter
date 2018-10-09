package com.example.imac.checkcounter.ui.router


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.util.Log
import com.example.imac.checkcounter.R
import com.example.imac.checkcounter.ui.screen.checkList.CheckListFragment
import com.example.imac.checkcounter.ui.screen.createCheck.CreateCheckFragment

class Router private constructor() : IRouter {

    init {
        Log.d(TAG, "Instance Router")
    }

    companion object {
        private val TAG = Router::class.java.simpleName
        private var instance: Router? = null
        private var localFragmentManager: FragmentManager? = null

        fun getInstance(fragmentManager: FragmentManager?): Router {
            synchronized(this) {
                if (instance == null) {
                    this.localFragmentManager = fragmentManager
                    instance = Router()
                }
            }
            return instance!!
        }

        const val CHECK_LIST = "checkList"
        const val CREATE_CHECK = "createCheck"
    }

    override fun add(fragmentId: String) {
        val transaction = localFragmentManager!!.beginTransaction()
        val fragm = getFragment(fragmentId)

        if (localFragmentManager!!.findFragmentByTag(fragm.tag) == null) {
            Log.d(TAG, "Instance != null")
            transaction.add(R.id.splash_container, fragm, fragm.tag)
        }
        transaction.commit()
    }

    override fun replace(fragmentId: String) {
        val transaction = localFragmentManager!!.beginTransaction()
        val fragm = getFragment(fragmentId)
        if (localFragmentManager!!.findFragmentByTag(fragm.tag) == null) {
            transaction.replace(R.id.splash_container, fragm, fragm.tag)
        }
        transaction.commit()
    }

    override fun remove(fragmentId: String) {
        val transaction = localFragmentManager!!.beginTransaction()
        val fragm = getFragment(fragmentId)
        if (localFragmentManager!!.findFragmentByTag(fragm.tag) != null) {
            transaction.remove(fragm)
        }
        transaction.commit()
    }

    override fun getTransaction(): FragmentTransaction {
        return localFragmentManager!!.beginTransaction()
    }


    private fun getFragment(fragment: String) : Fragment{
        when(fragment) {
            CHECK_LIST   -> return CheckListFragment()
            CREATE_CHECK -> return CreateCheckFragment()
        }

        return CheckListFragment()
    }
}