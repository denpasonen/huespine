package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.Mall
import com.rightcode.huespine.domain.model.Product
import io.reactivex.Completable
import io.reactivex.Single

interface MallRepository {
    fun getMalls(
        start: Int,
        limit: Int
    ): Single<List<Mall>>

    fun getMallsId(
        id: Long
    ): Single<Mall>

    fun getMallsFilter(
        filter: String,
        start: Int,
        limit: Int
    ): Single<Pair<List<Mall>, Int>>

    fun getMallsIdProduct(
        id: Long,
        start: Int,
        perPage: Int
    ): Single<List<Product>>

    fun getMallRankFilter(
        typeIds: Array<Long>?,
        hashtagIds: Array<Long>?
    ): Single<List<Mall>>

    fun updateMallLike(
        id: Long,
        isLike: Boolean
    ): Completable
}