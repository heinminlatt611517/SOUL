package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.activity_create_new_password.*

class CreateNewPasswordActivity :BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, CreateNewPasswordActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_password)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        btn_resetPassword.setOnClickListener {
            startActivity(SuccessResetPasswordActivity.newIntent(this))
            slideToAnimation()
            finish()
        }

        iv_back.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
            slideBackAnimation()
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(LoginActivity.newIntent(this))
        slideBackAnimation()
        finish()
    }


}