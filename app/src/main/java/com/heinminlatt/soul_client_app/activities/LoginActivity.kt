package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.lifecycle.ViewModelProviders
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.shared.activity.hideKeyboard
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.mvp.presenters.LoginPresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.LoginPresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() , LoginView {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    private lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setUpPresenter()
        setUpActionListener()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        hideKeyboard(this)
        return super.dispatchTouchEvent(ev)
    }

    private fun setUpActionListener() {
        tv_register.setOnClickListener { mPresenter.onTapRegister() }

        btn_login.setOnClickListener { mPresenter.onTapLogin() }
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(LoginPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToUpdateProfileScreen() {
        startActivity(UpdateProfileActivity.newIntent(this))
        finish()
    }

    override fun navigateToSignUpScreen() {
        startActivity(SignUpActivity.newIntent(this))
        finish()
    }

    override fun showErrorMessage(errorMessage: String) {
        TODO("Not yet implemented")
    }
}