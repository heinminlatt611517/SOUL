package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.delegate.ProfileScreenItemDelegate
import com.heinminlatt.soul_client_app.mvp.views.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView>,ProfileScreenItemDelegate {
    fun onUiReady()
}