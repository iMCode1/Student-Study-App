package com.example.student_study_app.APIutils

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {//this class will manage all JWT tokens
    private val prefs: SharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        prefs.edit().putString("jwt_token", token).apply()
    }

    fun getToken(): String? {
        return prefs.getString("jwt_token", null)
    }

    fun clearToken() {
        prefs.edit().remove("jwt_token").apply()

    }
}