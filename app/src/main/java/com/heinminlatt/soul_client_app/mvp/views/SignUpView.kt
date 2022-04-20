package com.heinminlatt.soul_client_app.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface SignUpView : BaseView {
    fun navigateToLoginScreen()
    fun navigateToSignUpSuccess()
}