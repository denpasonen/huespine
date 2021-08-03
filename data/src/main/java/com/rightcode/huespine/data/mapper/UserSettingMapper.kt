package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.UserSettingData
import com.rightcode.huespine.domain.model.UserSetting

internal object UserSettingMapper : Mapper<UserSettingData, UserSetting> {
    override fun mapToDomain(from: UserSettingData): UserSetting {
        return UserSetting(
            userId = from.userId,
            agreeMarketing = from.agreeMarketing,
            allowOfflinePush = from.allowOfflinePush,
            allowOnlinePush = from.allowOnlinePush,
            allowSinglePush = from.allowSinglePush,
            allSpecialPush = from.allSpecialPush
        )
    }
}
