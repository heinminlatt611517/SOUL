package com.heinminlatt.soul_client_app.activities

import android.os.Bundle
import android.os.Handler
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R

class SplashScreenActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({

            startActivity(LoginActivity.newIntent(this))
            finish()
        },2000)
    }
}