package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.repository.VersionRepository
import io.reactivex.Single
import javax.inject.Inject

class VersionServiceImpl @Inject constructor(
    private val versionRepository: VersionRepository
) : VersionService {
    override fun getUpdateAvailable(versionCode: Int): Single<Boolean> {
        return versionRepository.getVersionCode()
            .map { newVersionCode ->
                versionCode < newVersionCode
            }
    }

    override fun getVersionName(packageName: String): Single<String> {
        return versionRepository.getVersionName(packageName)
    }

    override fun getLatestVersionCode(packageName: String): Single<Int> {
        return versionRepository.getVersionCode()
            .map { it }
    }
}