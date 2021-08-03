package com.rightcode.huespine.util

import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface ResourceProvider {
    fun getDrawable(@DrawableRes resId: Int): Drawable

    fun getString(@StringRes resId: Int): String

    fun getStringArray(@ArrayRes resId: Int): Array<String>

    fun getColor(@ColorRes resId: Int): Int
}