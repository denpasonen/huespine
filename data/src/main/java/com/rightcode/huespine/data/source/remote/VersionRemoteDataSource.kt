package com.rightcode.huespine.data.source.remote

import io.reactivex.Single

interface VersionRemoteDataSource {
    fun getVersionName(packageName: String): Single<String>

    fun getVersionCode(): Single<Int>
}