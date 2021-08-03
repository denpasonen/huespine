package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.UserSetting
import io.reactivex.Completable
import io.reactivex.Single

interface UserSettingService {
    fun getUserSetting(): Single<UserSetting>

    fun putUserSetting(
        agreeMarketing: Boolean?,
        allowOfflinePush: List<String>?,
        allowOnlinePush: Boolean?,
        allowSinglePush: Boolean?,
        allSpecialPush: Boolean?
    ): Completable
}