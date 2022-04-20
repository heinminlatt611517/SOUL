package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.delegate.HomeNewsTitleItemDelegate
import com.heinminlatt.soul_client_app.mvp.views.HomeView

interface HomePresenter : BasePresenter<HomeView>,HomeNewsTitleItemDelegate{
    fun onUiReady()
}