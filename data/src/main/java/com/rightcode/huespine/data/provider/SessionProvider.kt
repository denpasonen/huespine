package com.rightcode.huespine.data.provider

interface SessionProvider {
    val cookieSid: String?

    fun updateAccessToken(cookieSid: String)

    fun logout()
}