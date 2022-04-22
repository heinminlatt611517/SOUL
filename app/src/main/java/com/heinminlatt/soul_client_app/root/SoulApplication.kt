package com.heinminlatt.soul_client_app.root

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.heinminlatt.soul_client_app.utils.SessionManager

class SoulApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        SessionManager.init(applicationContext)
    }
}