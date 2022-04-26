package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.HomePresenter
import com.heinminlatt.soul_client_app.mvp.views.HomeView

class HomePresenterImpl : HomePresenter,AbstractBasePresenter<HomeView>() {
    override fun onUiReady() {

    }

    override fun onTapSearch() {
        mView?.navigateToSearchScreen()
    }

    override fun onTapNewsItem() {
        mView?.navigateToNewsDetailScreen()
    }

    override fun onTapSoloArtistItem() {
        mView?.navigateToSoloArtistDetailScreen()
    }

    override fun onTapLike() {

    }

    override fun onTapUnlike() {

    }

    override fun onTapMessage() {

    }
}