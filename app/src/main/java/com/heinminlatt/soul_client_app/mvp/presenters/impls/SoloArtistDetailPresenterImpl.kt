package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.SoloArtistDetailPresenter
import com.heinminlatt.soul_client_app.mvp.views.SoloArtistDetailView

class SoloArtistDetailPresenterImpl : SoloArtistDetailPresenter,AbstractBasePresenter<SoloArtistDetailView>() {
    override fun onUiReady() {

    }

    override fun onTapSoloImageItem(index :Int) {
        mView?.navigateToArtistSoloImageDetailScreen(index)
    }
}