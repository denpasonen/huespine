package com.rightcode.huespine.domain.repository


import com.rightcode.huespine.domain.model.UserSetting
import io.reactivex.Completable
import io.reactivex.Single

interface UserSettingRepository {
    fun getUserSetting(): Single<UserSetting>

    fun putUserSetting(
        agreeMarketing: Boolean?,
        allowOfflinePush: List<String>?,
        allowOnlinePush: Boolean?,
        allowSinglePush: Boolean?,
        allSpecialPush: Boolean?
    ): Completable
}