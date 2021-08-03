package com.rightcode.huespine.local.mapper

import com.rightcode.huespine.data.model.common.NaverAuthData
import com.rightcode.huespine.local.model.NaverAuthEntity

internal object NaverAuthMapper : Mapper<NaverAuthEntity, NaverAuthData> {
    override fun mapToData(from: NaverAuthEntity): NaverAuthData {
        return NaverAuthData(
            accessToken = from.accessToken,
            refreshToken = from.refreshToken
        )
    }

    override fun mapToLocal(from: NaverAuthData): NaverAuthEntity {
        return NaverAuthEntity(
            accessToken = from.accessToken,
            refreshToken = from.refreshToken
        )
    }

}