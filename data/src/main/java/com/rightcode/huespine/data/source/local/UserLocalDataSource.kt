package com.rightcode.huespine.data.source.local

import com.rightcode.huespine.data.model.UserData
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

interface UserLocalDataSource {

    fun getCurrentUser(): Flowable<Optional<UserData>>

    fun getUser(userId: Long): Single<UserData>

    fun save(user: UserData): Completable
}