package com.rightcode.huespine.domain.service

import io.reactivex.Completable
import io.reactivex.Flowable

interface SessionService {

    fun isAuthenticatedChanged(): Flowable<Boolean>

    fun logout(): Completable
}