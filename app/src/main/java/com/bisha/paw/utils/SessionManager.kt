package com.bisha.paw.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth

object PreferenceKeys {
    const val PREFERENCE_NAME = "preference_name"
    const val HAS_ONBOARDED = "has_onboarded"
}

class SessionManager(private val context: Context) {

    private val mPreferences: SharedPreferences by lazy {
        return@lazy context.getSharedPreferences(
            PreferenceKeys.PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }

    private val firebaseAuth: FirebaseAuth by lazy {
        return@lazy FirebaseAuth.getInstance()
    }

    fun isOnBoarded(): Boolean {
        return getBoolean(PreferenceKeys.HAS_ONBOARDED, false)
    }

    fun saveHasOnBoard(state: Boolean = true) {
        saveBoolean(PreferenceKeys.HAS_ONBOARDED, state)
    }

    fun isLoggedIn(): Boolean {
        return firebaseAuth.currentUser?.email?.isNotEmpty() ?: false
    }

    private fun getBoolean(key: String, default: Boolean): Boolean {
        return mPreferences.getBoolean(key, default)
    }

    private fun saveBoolean(key: String, value: Boolean) {
        mPreferences.edit().putBoolean(key, value).apply()
    }

    private fun getString(key: String, default: String): String {
        return mPreferences.getString(key, default).orEmpty()
    }

    private fun saveString(key: String, value: String) {
        mPreferences.edit().putString(key, value).apply()
    }

    private fun clearAll() {
        mPreferences.edit().clear().apply()
    }

    private fun remove(key: String) {
        mPreferences.edit().remove(key).apply()
    }

}