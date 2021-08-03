package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.UserSettingMapper
import com.rightcode.huespine.data.source.remote.UserSettingRemoteDataSource
import com.rightcode.huespine.domain.model.UserSetting
import com.rightcode.huespine.domain.repository.UserSettingRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UserSettingRepositoryImpl @Inject constructor(
    private val remote: UserSettingRemoteDataSource,
) : UserSettingRepository {

    override fun getUserSetting(): Single<UserSetting> = remote.getUserSetting().map(
        UserSettingMapper::mapToDomain
    )

    override fun putUserSetting(
        agreeMarketing: Boolean?,
        allowOfflinePush: List<String>?,
        allowOnlinePush: Boolean?,
        allowSinglePush: Boolean?,
        allSpecialPush: Boolean?
    ): Completable =
        remote.putUserSetting(
            agreeMarketing,
            allowOfflinePush,
            allowOnlinePush,
            allowSinglePush,
            allSpecialPush
        )
}