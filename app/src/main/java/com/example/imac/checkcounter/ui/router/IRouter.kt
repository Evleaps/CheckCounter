package com.example.imac.checkcounter.ui.router

interface IRouter {

    fun navigateTo(fragmentId: String)

    fun add(fragmentId: String)

    fun back()

    fun replace(fragmentId: String)

    fun remove(fragmentId: String)

    fun getTransaction(): android.support.v4.app.FragmentTransaction
}