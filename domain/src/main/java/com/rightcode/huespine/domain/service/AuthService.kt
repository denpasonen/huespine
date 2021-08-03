package com.rightcode.huespine.domain.service

import io.reactivex.Completable
import io.reactivex.Single

interface AuthService {

    fun login(
        email: String,
        password: String
    ): Completable

    fun register(
        type: String,
        email: String,
        name: String,
        password: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Completable

    fun checkEmailDuplicate(
        email: String
    ): Completable

    fun checkNicknameDuplicate(
        name: String
    ): Completable

    fun checkAuth(): Completable

    fun logout(): Completable

    fun passwordReset(email: String): Completable

    fun loginWithNaver(token: String): Completable

    fun loginWithKakao(token: String): Completable

    fun loginWithApple(
        token: String
    ): Completable

    fun loginWithGoogle(
        token: String
    ): Completable

    fun registerWithSocial(
        type: String,
        token: String,
        name: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Completable

    fun getTokenInfo(type: String, token: String): Single<String>

}