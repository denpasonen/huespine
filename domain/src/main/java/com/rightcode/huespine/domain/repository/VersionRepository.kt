package com.rightcode.huespine.domain.repository

import io.reactivex.Single

interface VersionRepository {
    fun getVersionName(packageName: String): Single<String>

    fun getVersionCode(): Single<Int>
}