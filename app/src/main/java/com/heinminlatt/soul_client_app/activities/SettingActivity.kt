package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity :BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, SettingActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        layout_eng.setOnClickListener {
            layout_eng.setBackgroundColor(resources.getColor(R.color.white))
            layout_my.setBackgroundColor(resources.getColor(R.color.statusTransparent))
        }
        layout_my.setOnClickListener {
            layout_eng.setBackgroundColor(resources.getColor(R.color.statusTransparent))
            layout_my.setBackgroundColor(resources.getColor(R.color.white))
        }
    }

    override fun finish() {
        super.finish()
        slideBackAnimation()
    }
}