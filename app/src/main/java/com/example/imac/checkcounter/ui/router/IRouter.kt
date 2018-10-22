package com.example.imac.checkcounter.ui.router

interface IRouter {

    fun navigateTo(fragmentId: String)

    fun add(fragmentId: String)

    fun replace(fragmentId: String)

    fun back()

    fun remove(fragmentId: String)

    fun getTransaction(): android.support.v4.app.FragmentTransaction
}