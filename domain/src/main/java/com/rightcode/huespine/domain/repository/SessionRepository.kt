package com.rightcode.huespine.domain.repository

import io.reactivex.Completable
import io.reactivex.Flowable
import java.util.*

interface SessionRepository {
    val userId: Long?

    fun fetchUserId(): Flowable<Optional<Long>>

    fun save(userId: Long): Completable

    fun clearAll(): Completable
}