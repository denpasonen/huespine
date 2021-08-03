package com.rightcode.huespine.local

import com.rightcode.huespine.data.source.local.SessionLocalDataSource
import com.rightcode.huespine.local.preferences.SessionPref
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

internal class SessionLocalDataSourceImpl @Inject constructor(
    private val sessionPref: SessionPref
) : SessionLocalDataSource {
    override val cookieSid: String?
        get() = sessionPref.cookieSid
    override val userId: Long?
        get() = sessionPref.currentUserId

    override fun saveUserId(userId: Long) {
        sessionPref.currentUserId = userId
    }

    override fun fetchUserId(): Flowable<Optional<Long>> {
        return sessionPref.fetchUserId()
            .startWith(Optional.ofNullable(this.userId))
    }

    override fun saveCookieSid(cookieSid: String) {
        sessionPref.cookieSid = cookieSid
    }

    override fun clearAll() {
        sessionPref.currentUserId = null
        sessionPref.cookieSid = null
    }
}