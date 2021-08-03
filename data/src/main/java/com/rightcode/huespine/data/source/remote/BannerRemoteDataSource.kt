package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.BannerData
import io.reactivex.Single


interface BannerRemoteDataSource {
    fun getBanners(type: String): Single<List<BannerData>>
}
