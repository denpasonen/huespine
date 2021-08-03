package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.User
import io.reactivex.Completable
import io.reactivex.Single

interface AuthRepository {
    fun login(
        email: String,
        password: String
    ): Single<User>

    fun register(
        type: String,
        email: String,
        name: String,
        password: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Single<User>

    fun checkEmailDuplicated(
        email: String
    ): Completable

    fun checkNicknameDuplicated(
        name: String
    ): Completable

    fun checkAuth(): Completable

    fun logout(): Completable

    fun passwordReset(email: String): Completable

    fun loginWithSocial(
        type: String,
        socialToken: String
    ): Single<User>

    fun registerWithSocial(
        type: String,
        socialToken: String,
        name: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Single<User>

    fun getTokenInfo(
        type: String,
        token: String
    ): Single<String>

}