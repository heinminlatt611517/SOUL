package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.mvp.views.SignUpView

interface SignUpPresenter : BasePresenter<SignUpView> {
    fun onTapSignUpGmail()
    fun onTapFacebook()
    fun onTapCheckBox()
    fun onTapSignUp()
    fun onTapSignIn()
}