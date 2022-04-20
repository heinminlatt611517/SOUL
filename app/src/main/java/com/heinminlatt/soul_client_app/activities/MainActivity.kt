package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R

class MainActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }
}