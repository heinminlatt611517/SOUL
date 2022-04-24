package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.ProfilePresenter
import com.heinminlatt.soul_client_app.mvp.views.ProfileView

class ProfilePresenterImpl : ProfilePresenter,AbstractBasePresenter<ProfileView>() {
    override fun onUiReady() {

    }

    override fun onTapEditProfile() {
        mView?.navigateToEditProfileScreen()
    }

    override fun onTapSetting() {
        mView?.navigateToSettingScreen()
    }

    override fun onTapMyFavourite() {
        mView?.navigateToMyFavouriteScreen()
    }
}