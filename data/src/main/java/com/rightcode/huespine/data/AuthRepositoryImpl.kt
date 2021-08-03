package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.UserMapper
import com.rightcode.huespine.data.source.remote.AuthRemoteDataSource
import com.rightcode.huespine.domain.model.User
import com.rightcode.huespine.domain.repository.AuthRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remote: AuthRemoteDataSource
) : AuthRepository {

    override fun login(email: String, password: String): Single<User> {
        return remote.login(email, password)
            .map(UserMapper::mapToDomain)
    }

    override fun register(
        type: String,
        email: String,
        name: String,
        password: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Single<User> {
        return remote.register(type, email, name, password, profileId, tasteIds, categoryIds)
            .map(UserMapper::mapToDomain)
    }

    override fun checkEmailDuplicated(email: String): Completable =
        remote.checkEmailDuplicated(email)

    override fun checkNicknameDuplicated(name: String): Completable =
        remote.checkNicknameDuplicated(name)

    override fun checkAuth(): Completable = remote.checkAuth()
    override fun logout(): Completable = remote.logout()
    override fun passwordReset(email: String) = remote.passwordReset(email)

    override fun loginWithSocial(type: String, socialToken: String): Single<User> {
        return remote.loginWithSocial(type, socialToken)
            .map(UserMapper::mapToDomain)
    }

    override fun registerWithSocial(
        type: String,
        socialToken: String,
        name: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Single<User> {
        return remote.registerWithSocial(type, socialToken, name, profileId, tasteIds, categoryIds)
            .map(UserMapper::mapToDomain)
    }

    override fun getTokenInfo(type: String, token: String): Single<String> {
        return remote.getTokenInfo(type, token)
    }
}