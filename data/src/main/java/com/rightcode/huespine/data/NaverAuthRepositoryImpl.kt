package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.NaverAuthMapper
import com.rightcode.huespine.data.source.local.NaverAuthLocalDataSource
import com.rightcode.huespine.domain.model.NaverAuth
import com.rightcode.huespine.domain.repository.NaverAuthRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class NaverAuthRepositoryImpl @Inject constructor(
    private val local: NaverAuthLocalDataSource
) : NaverAuthRepository {
    override fun getToken(): Single<NaverAuth> {
        return local.getToken()
            .map(NaverAuthMapper::mapToDomain)
    }

    override fun logout(): Completable {
        return local.logout()
    }
}