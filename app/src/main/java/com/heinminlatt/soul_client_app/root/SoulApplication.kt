package com.heinminlatt.soul_client_app.root

import android.app.Application
import com.heinminlatt.soul_client_app.utils.SessionManager

class SoulApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SessionManager.init(applicationContext)
    }
}