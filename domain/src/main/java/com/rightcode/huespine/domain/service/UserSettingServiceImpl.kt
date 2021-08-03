package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.UserSetting
import com.rightcode.huespine.domain.repository.UserSettingRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserSettingServiceImpl @Inject constructor(
    private val repository: UserSettingRepository
) : UserSettingService {
    override fun getUserSetting(): Single<UserSetting> = repository.getUserSetting()

    override fun putUserSetting(
        agreeMarketing: Boolean?,
        allowOfflinePush: List<String>?,
        allowOnlinePush: Boolean?,
        allowSinglePush: Boolean?,
        allSpecialPush: Boolean?
    ): Completable = repository.putUserSetting(
        agreeMarketing,
        allowOfflinePush,
        allowOnlinePush,
        allowSinglePush,
        allSpecialPush
    )
}