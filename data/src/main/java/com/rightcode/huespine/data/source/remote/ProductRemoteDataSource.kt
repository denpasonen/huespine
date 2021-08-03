package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.ProductData
import com.rightcode.huespine.data.model.common.OrderTypeData
import com.rightcode.huespine.data.model.common.SortTypeData
import io.reactivex.Completable
import io.reactivex.Single


interface ProductRemoteDataSource {

    fun getProducts(
        start: Int,
        limit: Int
    ): Single<List<ProductData>>

    fun getProductId(
        id: Long
    ): Single<ProductData>

    fun getProductsFilter(
        filter: String?,
        start: Int,
        limit: Int
    ): Single<Pair<List<ProductData>, Int>>

    fun getProductsCategoryId(
        categoryId: Int?,
        filter: String?,
        sort: SortTypeData,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderTypeData,
        start: Int,
        limit: Int
    ): Single<List<ProductData>>


    fun getProductsSearch(
        search: String,
        filter: String?,
        sort: SortTypeData,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderTypeData,
        start: Int,
        limit: Int
    ): Single<List<ProductData>>


    fun getProductsByFilter(
        categoryId: Int?,
        filter: String?,
        search: String?,
        minimumPrice: Long?,
        maximumPrice: Long?,
        sort: String?,
        order: String?,
        start: Int,
        perPage: Int,
    ): Single<Pair<List<ProductData>, Int>>

    fun updateProductLike(
        id: Long,
        isLike: Boolean
    ): Completable

    fun postKeywordLogs(
        keyword: String
    ): Completable
}
