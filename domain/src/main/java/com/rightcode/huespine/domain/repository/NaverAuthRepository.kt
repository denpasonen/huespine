package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.NaverAuth
import io.reactivex.Completable
import io.reactivex.Single

interface NaverAuthRepository {
    fun getToken(): Single<NaverAuth>

    fun logout(): Completable
}