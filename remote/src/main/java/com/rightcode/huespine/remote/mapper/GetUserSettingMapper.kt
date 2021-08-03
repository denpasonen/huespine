package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.UserSettingData
import com.rightcode.huespine.remote.model.response.GetUserSettingResponse

internal object GetUserSettingMapper :
    Mapper<GetUserSettingResponse, UserSettingData> {
    override fun mapToData(from: GetUserSettingResponse): UserSettingData {
        return UserSettingData(
            userId = from.userId,
            agreeMarketing = from.agreeMarketing,
            allowOfflinePush = from.allowOfflinePush,
            allowOnlinePush = from.allowOnlinePush,
            allowSinglePush = from.allowSinglePush,
            allSpecialPush = from.allSpecialPush,
        )
    }
}