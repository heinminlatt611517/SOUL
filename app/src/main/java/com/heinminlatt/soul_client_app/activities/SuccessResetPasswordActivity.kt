package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.activity_success_reset_password.*

class SuccessResetPasswordActivity :BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, SuccessResetPasswordActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success_reset_password)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        btn_done.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
            slideBackAnimation()
            finish()
        }
    }

    override fun onBackPressed() {
    }

}