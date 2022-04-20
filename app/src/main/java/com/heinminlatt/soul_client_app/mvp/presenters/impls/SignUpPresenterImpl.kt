package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.LoginPresenter
import com.heinminlatt.soul_client_app.mvp.presenters.SignUpPresenter
import com.heinminlatt.soul_client_app.mvp.views.LoginView
import com.heinminlatt.soul_client_app.mvp.views.SignUpView

class SignUpPresenterImpl : SignUpPresenter, AbstractBasePresenter<SignUpView>() {
    override fun onTapSignUpGmail() {

    }

    override fun onTapFacebook() {

    }

    override fun onTapCheckBox() {

    }

    override fun onTapSignUp() {
       mView?.navigateToSignUpSuccess()
    }

    override fun onTapSignIn() {
        mView?.navigateToLoginScreen()
    }

}