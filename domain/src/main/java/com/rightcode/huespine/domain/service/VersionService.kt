package com.rightcode.huespine.domain.service

import io.reactivex.Single

interface VersionService {
    fun getUpdateAvailable(
        versionCode: Int
    ): Single<Boolean>

    fun getVersionName(
        packageName: String
    ): Single<String>

    fun getLatestVersionCode(
        packageName: String
    ): Single<Int>
}