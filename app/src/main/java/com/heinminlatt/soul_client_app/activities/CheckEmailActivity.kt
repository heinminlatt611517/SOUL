package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.activity_check_email.*

class CheckEmailActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, CheckEmailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_email)


        setUpActionListener()
    }

    private fun setUpActionListener() {
        tv_skip.setOnClickListener {
            startActivity(CreateNewPasswordActivity.newIntent(this))
            slideToAnimation()
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(ForgotPasswordActivity.newIntent(this))
        slideBackAnimation()
        finish()
    }


}