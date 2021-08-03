package com.rightcode.huespine.util

import androidx.core.util.PatternsCompat
import java.util.regex.Pattern

object Patterns {
    @JvmStatic
    val NOT_EMPTY_STRING = Pattern.compile("^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|*]{1,30}")

    @JvmStatic
    val NAME = Pattern.compile("^[0-9a-zA-Z!_가-힣]{2,20}\$")

    @JvmStatic
    val EMAIL = PatternsCompat.EMAIL_ADDRESS

    @JvmStatic
    val PASSWORD = Pattern.compile("^[0-9a-zA-Z!@#\$%^&*()?+-_~=]{8,30}\$")

    @JvmStatic
    val PHONE = Pattern.compile("^01([0|1|6|7|8|9])([0-9]{3,4})([0-9]{4})\$")

    @JvmStatic
    val CERTIFY = Pattern.compile("^[0-9]{6}\$")
}