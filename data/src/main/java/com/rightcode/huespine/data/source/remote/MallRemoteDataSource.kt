package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.MallData
import com.rightcode.huespine.data.model.ProductData
import io.reactivex.Completable
import io.reactivex.Single


interface MallRemoteDataSource {

    fun getMall(
        start: Int,
        limit: Int
    ): Single<List<MallData>>

    fun getMallsId(
        id: Long
    ): Single<MallData>

    fun getMallsFilter(
        filter: String,
        start: Int,
        limit: Int
    ): Single<Pair<List<MallData>, Int>>

    fun getMallsIdProduct(
        id: Long,
        start: Int,
        perPage: Int
    ): Single<List<ProductData>>

    fun getMallRankFilter(
        typeIds: Array<Long>?,
        hashtagIds: Array<Long>?
    ): Single<List<MallData>>

    fun updateMallLike(
        id: Long,
        isLike: Boolean
    ): Completable
}
