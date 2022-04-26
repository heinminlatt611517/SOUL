package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.lifecycle.ViewModelProviders
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.shared.activity.hideKeyboard
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.mvp.presenters.SignUpPresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.SignUpPresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.SignUpView
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity(),SignUpView {
    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, SignUpActivity::class.java)
        }
    }

    private lateinit var mPresenter : SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setUpPresenter()
        setUpActionListener()


    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        hideKeyboard(this)
        return super.dispatchTouchEvent(ev)
    }

    private fun setUpActionListener() {
        btn_sign_up.setOnClickListener {
            mPresenter.onTapSignUp()
        }

        tv_signIn.setOnClickListener {
            mPresenter.onTapSignIn()
        }

    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(SignUpPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
        slideBackAnimation()
        finish()
    }

    override fun navigateToSignUpSuccess() {
        startActivity(SignUpSuccessActivity.newIntent(this))
        slideToAnimation()
        finish()
    }

    override fun showErrorMessage(errorMessage: String) {

    }

}