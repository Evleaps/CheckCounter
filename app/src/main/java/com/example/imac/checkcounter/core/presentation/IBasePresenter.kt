package com.example.imac.checkcounter.core.presentation

interface IBasePresenter {
    fun attachView(view: IBaseView)
    fun detachView()
}