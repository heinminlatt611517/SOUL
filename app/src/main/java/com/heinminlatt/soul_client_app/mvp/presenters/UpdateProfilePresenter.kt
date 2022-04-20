package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.mvp.views.UpdateProfileView

interface UpdateProfilePresenter : BasePresenter<UpdateProfileView> {
    fun onTapUploadImage()
    fun onTapLetRock()
    fun onTapSkip()
}