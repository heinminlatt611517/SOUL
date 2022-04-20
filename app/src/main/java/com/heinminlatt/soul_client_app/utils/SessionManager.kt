package com.heinminlatt.soul_client_app.utils

import android.content.Context
import android.content.SharedPreferences



object SessionManager {

    private const val NAME = sharePreferenceName
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var language: String?
        get() = preferences.getString(sharePreferenceLanguageStatus, "")
        set(value) = preferences.edit {
            it.putString(sharePreferenceLanguageStatus, value)
        }

    var isLogin: String?
        get() = preferences.getString(sharePreferenceLoginStatus, "")
        set(value) = preferences.edit {
            it.putString(sharePreferenceLoginStatus, value)
        }

}