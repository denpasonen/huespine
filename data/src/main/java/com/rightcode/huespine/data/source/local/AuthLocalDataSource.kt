package com.rightcode.huespine.data.source.local

import io.reactivex.Completable

interface AuthLocalDataSource {

    var cookieSid: String?
    var userId: Long?

    fun save(cookieSid: String): Completable

    fun deleteAll()
}