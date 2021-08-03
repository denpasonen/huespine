package com.rightcode.huespine.util.ext

import java.text.NumberFormat

fun Int.toNumberFormat(): String {
    return NumberFormat.getInstance().format(this)
}
