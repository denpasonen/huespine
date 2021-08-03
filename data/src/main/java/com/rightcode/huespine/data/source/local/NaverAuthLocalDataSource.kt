package com.rightcode.huespine.data.source.local

import com.rightcode.huespine.data.model.common.NaverAuthData
import io.reactivex.Completable
import io.reactivex.Single

interface NaverAuthLocalDataSource {
    fun getToken(): Single<NaverAuthData>

    fun logout(): Completable
}