package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.mvp.views.LoginView

interface LoginPresenter : BasePresenter<LoginView> {
    fun onTapLogin()
    fun onTapForgotPassword()
    fun onTapGoogle()
    fun onTapFacebook()
    fun onTapRegister()
}