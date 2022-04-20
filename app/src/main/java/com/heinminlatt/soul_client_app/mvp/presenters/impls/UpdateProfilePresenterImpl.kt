package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.UpdateProfilePresenter
import com.heinminlatt.soul_client_app.mvp.views.UpdateProfileView

class UpdateProfilePresenterImpl : UpdateProfilePresenter,AbstractBasePresenter<UpdateProfileView>() {
    override fun onTapUploadImage() {

    }

    override fun onTapLetRock() {
        mView?.navigateToMainScreen()
    }

    override fun onTapSkip() {
        mView?.navigateToMainScreen()
    }
}