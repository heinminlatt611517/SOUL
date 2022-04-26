package com.heinminlatt.soul_client_app.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface LoginView : BaseView {
    fun  navigateToUpdateProfileScreen()
    fun  navigateToSignUpScreen()
    fun  navigateToForgotPasswordScreen()

}