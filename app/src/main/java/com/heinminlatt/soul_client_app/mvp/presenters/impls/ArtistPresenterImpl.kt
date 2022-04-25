package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.ArtistPresenter
import com.heinminlatt.soul_client_app.mvp.views.ArtistView

class ArtistPresenterImpl : ArtistPresenter,AbstractBasePresenter<ArtistView>() {
    override fun onUiReady() {

    }

    override fun onTapGroupArtistItem() {
        mView?.navigateToGroupArtistDetailScreen()
    }

    override fun onTapViewMoreBoy() {

    }

    override fun onTapViewMoreGirl() {

    }

    override fun onTapViewMoreSoloArtist() {

    }
}