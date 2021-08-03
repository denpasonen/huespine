package com.rightcode.huespine.local

import com.rightcode.huespine.data.source.local.AuthLocalDataSource
import com.rightcode.huespine.local.preferences.SessionPref
import com.rightcode.huespine.local.utils.rx.ext.mapToDataError
import com.rightcode.huespine.local.utils.rx.schedulers.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.internal.operators.completable.CompletableDefer
import javax.inject.Inject

internal class AuthLocalDataSourceImpl @Inject constructor(
    private val sessionPref: SessionPref,
    private val schedulerProvider: SchedulerProvider
) : AuthLocalDataSource {
    override var cookieSid: String?
        get() = sessionPref.cookieSid
        set(value) {
            sessionPref.cookieSid = value
        }

    override var userId: Long?
        get() = sessionPref.currentUserId
        set(value) {
            sessionPref.currentUserId = value
        }

    override fun save(cookieSid: String): Completable {
        return CompletableDefer {
            sessionPref.cookieSid = cookieSid
            Completable.complete()
        }.subscribeOn(schedulerProvider.io)
            .mapToDataError()
    }

    override fun deleteAll() {
        cookieSid = null
        userId = null
    }
}