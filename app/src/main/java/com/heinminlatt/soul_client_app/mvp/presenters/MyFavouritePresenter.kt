package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.delegate.MyFavouriteScreenItemDelegate
import com.heinminlatt.soul_client_app.mvp.views.MyFavouriteView

interface MyFavouritePresenter : BasePresenter<MyFavouriteView>,MyFavouriteScreenItemDelegate {
    fun onUIReady()
}