package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.common.NaverAuthData
import com.rightcode.huespine.domain.model.NaverAuth

internal object NaverAuthMapper : Mapper<NaverAuthData, NaverAuth> {
    override fun mapToDomain(from: NaverAuthData): NaverAuth {
        return NaverAuth(
            accessToken = from.accessToken,
            refreshToken = from.refreshToken
        )
    }

}