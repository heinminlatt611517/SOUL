package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.delegate.SoloArtistDetailScreenItemDelegate
import com.heinminlatt.soul_client_app.mvp.views.SoloArtistDetailView

interface SoloArtistDetailPresenter : BasePresenter<SoloArtistDetailView>,SoloArtistDetailScreenItemDelegate {
    fun onUiReady()
}