package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.activity_sign_up_success.*

class SignUpSuccessActivity :BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, SignUpSuccessActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_success)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        btn_go_back_login.setOnClickListener {
            startActivity(LoginActivity.newIntent(this))
            finish()
        }
    }
}