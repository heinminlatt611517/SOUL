package com.heinminlatt.soul_client_app.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface ProfileView : BaseView {
    fun navigateToSettingScreen()
    fun navigateToEditProfileScreen()
    fun navigateToMyFavouriteScreen()
}