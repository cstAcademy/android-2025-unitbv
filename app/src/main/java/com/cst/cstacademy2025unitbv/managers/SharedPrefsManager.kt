package com.cst.cstacademy2025unitbv.managers

import android.content.Context
import com.cst.cstacademy2025unitbv.ApplicationController

object SharedPrefsManager {

    const val SHARED_PREFS_NAME = "appSharedPrefs"

    const val ARK_AUTH_TOKEN = "auth_token"

    fun saveAuthToken(token: String) {
        with(sharedPrefs.edit()) {
            putString(ARK_AUTH_TOKEN, token)
            apply()
        }
    }

    fun getAuthToken(): String? = sharedPrefs.getString(ARK_AUTH_TOKEN, null)

    val sharedPrefs = ApplicationController.instance.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE
    )

}