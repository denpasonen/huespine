package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.MallData
import com.rightcode.huespine.data.model.ProductData
import com.rightcode.huespine.data.source.remote.MallRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetMallListMapper
import com.rightcode.huespine.remote.mapper.GetMallMapper
import com.rightcode.huespine.remote.mapper.GetMallProductListMapper
import com.rightcode.huespine.remote.model.request.Order
import com.rightcode.huespine.remote.model.request.Sort
import com.rightcode.huespine.remote.retrofit.api.MallApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class MallRemoteDataSourceImpl @Inject constructor(
    private val api: MallApi,
    private val gson: Gson
) : MallRemoteDataSource {

    override fun getMall(start: Int, limit: Int): Single<List<MallData>> {
        return api.getMalls(
            filter = null,
            search = null,
            sort = Sort.CREATED_AT,
            order = Order.DESC,
            start = start,
            perPage = limit
        ).map(GetMallListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getMallsId(id: Long): Single<MallData> {
        return api.getMallsId(
            id = id
        ).map(GetMallMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getMallsFilter(
        filter: String,
        start: Int,
        limit: Int
    ): Single<Pair<List<MallData>, Int>> {
        return api.getMalls(
            filter = filter,
            search = null,
            sort = Sort.CREATED_AT,
            order = Order.DESC,
            start = start,
            perPage = limit
        ).map { response ->
            GetMallListMapper.mapToData(response) to response.total
        }.catchRemoteError(gson)
    }

    override fun getMallsIdProduct(
        id: Long,
        start: Int,
        perPage: Int
    ): Single<List<ProductData>> {
        return api.getMallsIdProduct(
            id = id,
            start = start,
            perPage = perPage
        ).map(GetMallProductListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getMallRankFilter(
        typeIds: Array<Long>?,
        hashtagIds: Array<Long>?
    ): Single<List<MallData>> {
        return api.getMallsRankFilter(
            typeIds = typeIds,
            hashtagIds = hashtagIds,
        ).map(GetMallListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun updateMallLike(id: Long, isLike: Boolean): Completable {
        return api.postMallIdLiked(id, isLike)
            .catchRemoteError(gson)
    }
}