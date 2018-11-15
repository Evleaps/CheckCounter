package com.example.imac.checkcounter.core.presentation

abstract class BasePresenter<V : IBaseView> : IBasePresenter {
    protected var view: V? = null

    override fun attachView(view: IBaseView) {
        this.view = view as V
    }

    override fun detachView() {
        this.view = null
    }
}