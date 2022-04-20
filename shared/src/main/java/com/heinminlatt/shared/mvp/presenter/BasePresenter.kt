package com.heinminlatt.shared.mvp.presenter

import com.heinminlatt.shared.mvp.view.BaseView

interface BasePresenter<T : BaseView>{
    fun initPresenter(view : T)
}