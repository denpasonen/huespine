package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.ProductData
import com.rightcode.huespine.data.source.remote.HomeRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetHomeListMapper
import com.rightcode.huespine.remote.retrofit.api.HomeApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Single
import javax.inject.Inject

internal class HomeRemoteDataSourceImpl @Inject constructor(
    private val api: HomeApi,
    private val gson: Gson
) : HomeRemoteDataSource {
    override fun getProducts(): Single<Pair<List<ProductData>, Boolean>> {
        return api.getHomes()
            .map { response ->
                GetHomeListMapper.mapToData(response) to response.isNew
            }
            .catchRemoteError(gson)
    }
}