package com.rightcode.huespine.remote.utils

import com.rightcode.huespine.data.util.SafeEnumValue

inline fun <reified T> String.enumValueOrNull(): T? where T : Enum<*>, T : SafeEnumValue =
    T::class.java.enumConstants?.firstOrNull { it.value == this }