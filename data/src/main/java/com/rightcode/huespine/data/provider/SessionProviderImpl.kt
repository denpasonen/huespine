package com.rightcode.huespine.data.provider

import com.rightcode.huespine.data.source.local.SessionLocalDataSource
import javax.inject.Inject

internal class SessionProviderImpl @Inject constructor(
    private val local: SessionLocalDataSource
) : SessionProvider {
    override val cookieSid: String?
        get() = local.cookieSid

    override fun updateAccessToken(cookieSid: String) {
        local.saveCookieSid(cookieSid)
    }

    override fun logout() {
        local.clearAll()
    }
}