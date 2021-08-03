package com.rightcode.huespine.local.preferences

import android.content.Context
import android.content.SharedPreferences
import com.rightcode.huespine.local.BuildConfig

internal object SharedPreferencesFactory {
    private const val SHARED_PREF_NAME = BuildConfig.LIBRARY_PACKAGE_NAME + ".pref"

    @JvmStatic
    fun create(context: Context): SharedPreferences = context.applicationContext
        .getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
}