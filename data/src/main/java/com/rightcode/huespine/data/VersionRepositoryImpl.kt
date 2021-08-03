package com.rightcode.huespine.data

import com.rightcode.huespine.data.source.remote.VersionRemoteDataSource
import com.rightcode.huespine.domain.repository.VersionRepository
import io.reactivex.Single
import javax.inject.Inject

class VersionRepositoryImpl @Inject constructor(
    private val remote: VersionRemoteDataSource
) : VersionRepository {
    override fun getVersionName(packageName: String): Single<String> {
        return remote.getVersionName(packageName)
    }

    override fun getVersionCode(): Single<Int> {
        return remote.getVersionCode()
    }
}