package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.UserProfileData
import com.rightcode.huespine.data.source.remote.UserRemoteDataSource
import com.rightcode.huespine.remote.mapper.CategoryListMapper
import com.rightcode.huespine.remote.mapper.GetUserProfileMapper
import com.rightcode.huespine.remote.mapper.ProfileCharactersListMapper
import com.rightcode.huespine.remote.mapper.TastesListMapper
import com.rightcode.huespine.remote.retrofit.api.UserApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

internal class UsersRemoteDataSourceImpl @Inject constructor(
    private val api: UserApi,
    private val gson: Gson
) : UserRemoteDataSource {

    override fun getCategories() = api.getCategories()
        .map(CategoryListMapper::mapToData)
        .catchRemoteError(gson)

    override fun getProfileCharacters() = api.getProfileCharacters()
        .map(ProfileCharactersListMapper::mapToData)
        .catchRemoteError(gson)

    override fun getTastes() = api.getTastes()
        .map(TastesListMapper::mapToData)
        .catchRemoteError(gson)

    override fun getUserProfile(id: Long): Single<UserProfileData> = api.getUserId(id)
        .map(GetUserProfileMapper::mapToData)
        .catchRemoteError(gson)

    override fun updateName(name: String): Completable {
        return api.putUser(
            "{\"name\":\"$name\"}"
                .toRequestBody("application/json".toMediaType())
        ).catchRemoteError(gson)
    }

    override fun updateProfileCharacter(profileId: Int): Completable {
        return api.putUser(
            "{\"profileId\":$profileId}"
                .toRequestBody("application/json".toMediaType())
        ).catchRemoteError(gson)
    }

    override fun updateTaste(tasteIds: List<Int>): Completable {
        return api.putUser(
            "{\"tasteIds\":$tasteIds}"
                .toRequestBody("application/json".toMediaType())
        ).catchRemoteError(gson)
    }

    override fun updateCategory(categoryIds: List<Int>): Completable {
        return api.putUser(
            "{\"categoryIds\":$categoryIds}"
                .toRequestBody("application/json".toMediaType())
        ).catchRemoteError(gson)
    }

    override fun getUser(): Single<UserProfileData> = api.getUser()
        .map(GetUserProfileMapper::mapToData)
        .catchRemoteError(gson)

    override fun updatePassword(currentPassword: String, password: String): Completable {
        return api.putUserPassword(
            ("{\"currentPassword\":\"$currentPassword\",\"password\":\"$password\"}").toRequestBody(
                "application/json".toMediaType()
            )
        ).catchRemoteError(gson)
    }
}
