package com.rightcode.huespine.util.ext

import android.content.Context

inline fun <reified T> Context.systemService() = lazy {
    this.getSystemService(T::class.java)
}