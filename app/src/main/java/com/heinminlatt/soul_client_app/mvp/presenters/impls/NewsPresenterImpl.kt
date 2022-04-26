package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.HomePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.NewsPresenter
import com.heinminlatt.soul_client_app.mvp.views.HomeView
import com.heinminlatt.soul_client_app.mvp.views.NewsView

class NewsPresenterImpl : NewsPresenter,AbstractBasePresenter<NewsView>() {
    override fun onUiReady() {

    }

    override fun onTapNewsItem() {
      mView?.navigateToNewsDetailScreen()
    }

    override fun onTapSoloArtistItem() {
    }

    override fun onTapLike() {

    }

    override fun onTapUnlike() {

    }

    override fun onTapMessage() {

    }


}