package com.tweener.android.common.util

import android.content.Context
import android.content.SharedPreferences

/**
 * @author Vivien Mahe
 */
class SharedPreferencesUtils {

    companion object {
        private val PREFS_STORE_NAME = "xYBvVnqC5n"

        private fun getPrefs(context: Context): SharedPreferences {
            return context.getSharedPreferences(PREFS_STORE_NAME, Context.MODE_PRIVATE)
        }

        @Suppress("UNCHECKED_CAST")
        fun <T> get(context: Context, key: String, value: T?): T? {
            val prefs = getPrefs(context)
            return when (value) {
                is String -> prefs.getString(key, value) as T
                is Int -> prefs.getInt(key, value) as T
                is Boolean -> prefs.getBoolean(key, value) as T
                is Long -> prefs.getLong(key, value) as T
                is Float -> prefs.getFloat(key, value) as T
                else -> prefs.getString(key, null) as T
            }
        }

        fun <T> set(context: Context, key: String, value: T?) {
            val prefs = getPrefs(context)
            when (value) {
                is String -> prefs.edit().putString(key, value).apply()
                is Int -> prefs.edit().putInt(key, value).apply()
                is Boolean -> prefs.edit().putBoolean(key, value).apply()
                is Long -> prefs.edit().putLong(key, value).apply()
                is Float -> prefs.edit().putFloat(key, value).apply()
                else -> error("Only primitive types can be stored in SharedPreferences")
            }
        }

        fun clear(context: Context) {
            val prefs = getPrefs(context)
            prefs.edit().clear().apply()
        }
    }
}