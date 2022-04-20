package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.LoginPresenter
import com.heinminlatt.soul_client_app.mvp.views.LoginView

class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {
    override fun onTapLogin() {
        mView?.navigateToUpdateProfileScreen()
    }

    override fun onTapForgotPassword() {

    }

    override fun onTapGoogle() {

    }

    override fun onTapFacebook() {

    }

    override fun onTapRegister() {
        mView?.navigateToSignUpScreen()
    }

}