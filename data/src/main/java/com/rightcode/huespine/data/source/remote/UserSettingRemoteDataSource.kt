package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.UserSettingData
import io.reactivex.Completable
import io.reactivex.Single


interface UserSettingRemoteDataSource {
    fun getUserSetting(): Single<UserSettingData>

    fun putUserSetting(
        agreeMarketing: Boolean?,
        allowOfflinePush: List<String>?,
        allowOnlinePush: Boolean?,
        allowSinglePush: Boolean?,
        allSpecialPush: Boolean?
    ): Completable
}