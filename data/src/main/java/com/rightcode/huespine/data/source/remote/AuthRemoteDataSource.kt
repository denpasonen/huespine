package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.UserData
import io.reactivex.Completable
import io.reactivex.Single


interface AuthRemoteDataSource {

    fun login(
        email: String,
        password: String
    ): Single<UserData>

    fun register(
        type: String,
        email: String,
        name: String,
        password: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Single<UserData>

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
    ): Single<UserData>

    fun registerWithSocial(
        type: String,
        socialToken: String,
        name: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Single<UserData>

    fun getTokenInfo(
        type: String,
        token: String
    ): Single<String>

}
