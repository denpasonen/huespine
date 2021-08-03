package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.UserData
import com.rightcode.huespine.data.source.remote.AuthRemoteDataSource
import com.rightcode.huespine.remote.mapper.AuthResponseMapper
import com.rightcode.huespine.remote.mapper.AuthSocialResponseMapper
import com.rightcode.huespine.remote.mapper.AuthSocialTokenInfoResponseMapper
import com.rightcode.huespine.remote.model.request.PostAuthSocialRegisterRequest
import com.rightcode.huespine.remote.retrofit.api.AuthApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

internal class AuthRemoteDataSourceImpl @Inject constructor(
    private val api: AuthApi,
    private val gson: Gson
) : AuthRemoteDataSource {

    override fun login(email: String, password: String): Single<UserData> {
        return api.postAuth(email, password)
            .map(AuthResponseMapper::mapToData)
            .catchRemoteError()
    }

    override fun register(
        type: String,
        email: String,
        name: String,
        password: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Single<UserData> {
        return api.postAuthRegister(type, email, name, password, profileId, tasteIds, categoryIds)
            .map(AuthResponseMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun checkEmailDuplicated(email: String): Completable {
        return api.getEmailValid(email).catchRemoteError(gson)
    }

    override fun checkNicknameDuplicated(name: String): Completable {
        return api.getNicknameValid(name).catchRemoteError(gson)
    }

    override fun checkAuth(): Completable = api.getAuth()

    override fun logout(): Completable = api.deleteLogout()

    override fun passwordReset(email: String) =
        api.postAuthReset("{\"email\":\"$email\"}".toRequestBody("application/json".toMediaType()))
            .catchRemoteError(gson)

    override fun loginWithSocial(type: String, socialToken: String): Single<UserData> {
        return api.getAuthSocial(type = type, token = socialToken, platform = "android")
            .map(AuthSocialResponseMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun registerWithSocial(
        type: String,
        socialToken: String,
        name: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Single<UserData> {
        return api.postAuthSocial(
            PostAuthSocialRegisterRequest(
                type = type,
                token = socialToken,
                name = name,
                profileId = profileId,
                tasteIds = tasteIds,
                categoryIds = categoryIds
            )
        ).map(AuthResponseMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getTokenInfo(type: String, token: String): Single<String> {
        return api.getAuthSocialTokenInfo(type = type, token = token, platform = "android")
            .map { response ->
                type to response
            }.map(AuthSocialTokenInfoResponseMapper::mapToData)
            .catchRemoteError(gson)
    }
}