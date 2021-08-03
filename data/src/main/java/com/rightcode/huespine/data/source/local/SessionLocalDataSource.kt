package com.rightcode.huespine.data.source.local

import io.reactivex.Flowable
import java.util.*

interface SessionLocalDataSource {
    val cookieSid: String?
    val userId: Long?

    fun fetchUserId(): Flowable<Optional<Long>>

    fun saveCookieSid(cookieSid: String)

    fun saveUserId(userId: Long)

    fun clearAll()
}