package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.HomePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.VideoPresenter
import com.heinminlatt.soul_client_app.mvp.views.HomeView
import com.heinminlatt.soul_client_app.mvp.views.VideoView

class VideoPresenterImpl : VideoPresenter,AbstractBasePresenter<VideoView>() {
    override fun onUiReady() {

    }

    override fun onTapTopVideoItem() {
        mView?.navigateToVideoDetailScreen()
    }

}