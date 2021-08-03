package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.BannerData
import com.rightcode.huespine.data.source.remote.BannerRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetBannerListMapper
import com.rightcode.huespine.remote.retrofit.api.BannerApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

internal class BannerRemoteDataSourceImpl @Inject constructor(
    private val api: BannerApi,
    private val gson: Gson
) : BannerRemoteDataSource {
    override fun getBanners(type: String): Single<List<BannerData>> {
        return api.getBanners(type)
            .map(GetBannerListMapper::mapToData)
            .catchRemoteError(gson)
    }
}