package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.UserSettingData
import com.rightcode.huespine.data.source.remote.UserSettingRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetUserSettingMapper
import com.rightcode.huespine.remote.retrofit.api.UserSettingApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

internal class UserSettingRemoteDataSourceImpl @Inject constructor(
    private val api: UserSettingApi,
    private val gson: Gson
) : UserSettingRemoteDataSource {

    override fun getUserSetting(): Single<UserSettingData> = api.getCategories()
        .map(GetUserSettingMapper::mapToData)
        .catchRemoteError(gson)

    override fun putUserSetting(
        agreeMarketing: Boolean?,
        allowOfflinePush: List<String>?,
        allowOnlinePush: Boolean?,
        allowSinglePush: Boolean?,
        allSpecialPush: Boolean?
    ): Completable {
        val offlineToJson = gson.toJson(allowOfflinePush)
        return api.putUser(
            ("{\"agreeMarketing\":$agreeMarketing,\"allowOfflinePush\":${offlineToJson}," +
                    "\"allowOnlinePush\":$allowOnlinePush,\"allowSinglePush\":$allowSinglePush," +
                    "\"allSpecialPush\":$allSpecialPush}").toRequestBody(
                "application/json".toMediaType()
            )
        ).catchRemoteError(gson)
    }
}
