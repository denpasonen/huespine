package com.rightcode.huespine.local.naver

import com.rightcode.huespine.local.model.NaverAuthEntity
import io.reactivex.Completable
import io.reactivex.Single

internal interface NaverWrapper {
    fun getToken(): Single<NaverAuthEntity>

    fun logout(): Completable
}