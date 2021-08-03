package com.rightcode.huespine.local.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

object ContextCompatUtil {
    @JvmStatic
    fun checkSelfPermissions(context: Context, vararg permissions: String): Boolean {
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(
                    context.applicationContext,
                    permission
                ) == PackageManager.PERMISSION_DENIED
            ) {
                return false
            }
        }
        return true
    }
}