package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.delegate.ArtistScreenItemDelegate
import com.heinminlatt.soul_client_app.mvp.views.ArtistView

interface ArtistPresenter : BasePresenter<ArtistView>,ArtistScreenItemDelegate {
    fun onUiReady()
}