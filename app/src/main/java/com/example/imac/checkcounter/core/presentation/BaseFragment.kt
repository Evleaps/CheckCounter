package com.example.imac.checkcounter.core.presentation


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

abstract class BaseFragment<P : IBasePresenter> : IBaseView, Fragment()  {
    protected abstract val presenter: P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }
}