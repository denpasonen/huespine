package com.rightcode.huespine.local

import com.rightcode.huespine.data.model.common.NaverAuthData
import com.rightcode.huespine.data.source.local.NaverAuthLocalDataSource
import com.rightcode.huespine.local.mapper.NaverAuthMapper
import com.rightcode.huespine.local.naver.NaverWrapper
import com.rightcode.huespine.local.utils.rx.ext.mapToDataError
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class NaverAuthLocalDataSourceImpl @Inject constructor(
    private val naverWrapper: NaverWrapper
) : NaverAuthLocalDataSource {
    override fun getToken(): Single<NaverAuthData> {
        return naverWrapper.getToken()
            .map(NaverAuthMapper::mapToData)
            .mapToDataError()
    }

    override fun logout(): Completable {
        return naverWrapper.logout()
            .mapToDataError()
    }
}