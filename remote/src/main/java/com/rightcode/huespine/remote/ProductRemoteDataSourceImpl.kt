package com.rightcode.huespine.remote

import com.rightcode.huespine.data.model.ProductData
import com.rightcode.huespine.data.model.common.OrderTypeData
import com.rightcode.huespine.data.model.common.SortTypeData
import com.rightcode.huespine.data.source.remote.ProductRemoteDataSource
import com.rightcode.huespine.remote.mapper.GetProductListMapper
import com.rightcode.huespine.remote.mapper.GetProductMapper
import com.rightcode.huespine.remote.model.request.Order
import com.rightcode.huespine.remote.model.request.Sort
import com.rightcode.huespine.remote.retrofit.api.ProductApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

internal class ProductRemoteDataSourceImpl @Inject constructor(
    private val api: ProductApi,
    private val gson: Gson
) : ProductRemoteDataSource {
    override fun getProducts(
        start: Int,
        limit: Int
    ): Single<List<ProductData>> {
        return api.getProducts(
            mallId = null,
            search = null,
            categoryId = null,
            filter = null,
            sort = Sort.CREATED_AT,
            minimumPrice = null,
            maximumPrice = null,
            order = Order.DESC,
            start = start,
            perPage = limit
        ).map(GetProductListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getProductId(id: Long): Single<ProductData> = api.getProducts(id)
        .map(GetProductMapper::mapToData)
        .catchRemoteError(gson)


    override fun getProductsFilter(
        filter: String?,
        start: Int,
        limit: Int
    ): Single<Pair<List<ProductData>, Int>> {
        return api.getProducts(
            mallId = null,
            search = null,
            categoryId = null,
            filter = filter,
            sort = Sort.CREATED_AT,
            minimumPrice = null,
            maximumPrice = null,
            order = Order.DESC,
            start = start,
            perPage = limit
        ).map { response ->
            GetProductListMapper.mapToData(response) to response.total
        }.catchRemoteError(gson)
    }

    override fun getProductsCategoryId(
        categoryId: Int?,
        filter: String?,
        sort: SortTypeData,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderTypeData,
        start: Int,
        limit: Int
    ): Single<List<ProductData>> {
        return api.getProducts(
            mallId = null,
            search = null,
            categoryId = categoryId,
            filter = filter,
            sort = Sort.mapFromData(sort),
            minimumPrice = minimumPrice,
            maximumPrice = maximumPrice,
            order = Order.mapFromData(order),
            start = start,
            perPage = limit
        ).map(GetProductListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getProductsSearch(
        search: String,
        filter: String?,
        sort: SortTypeData,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderTypeData,
        start: Int,
        limit: Int
    ): Single<List<ProductData>> {
        return api.getProducts(
            mallId = null,
            search = search,
            categoryId = null,
            filter = filter,
            sort = Sort.mapFromData(sort),
            minimumPrice = minimumPrice,
            maximumPrice = maximumPrice,
            order = Order.mapFromData(order),
            start = start,
            perPage = limit
        ).map(GetProductListMapper::mapToData)
            .catchRemoteError(gson)
    }

    override fun getProductsByFilter(
        categoryId: Int?,
        filter: String?,
        search: String?,
        minimumPrice: Long?,
        maximumPrice: Long?,
        sort: String?,
        order: String?,
        start: Int,
        perPage: Int
    ): Single<Pair<List<ProductData>, Int>> {
        return api.getProducts(
            mallId = null,
            search = search,
            categoryId = categoryId,
            filter = filter,
            sort = Sort.CREATED_AT,
            minimumPrice = minimumPrice,
            maximumPrice = maximumPrice,
            order = Order.DESC,
            start = start,
            perPage = perPage
        ).map { response ->
            GetProductListMapper.mapToData(response) to response.total
        }
            .catchRemoteError(gson)

    }

    override fun updateProductLike(id: Long, isLike: Boolean): Completable {
        return api.postProductIdLiked(id, isLike)
            .catchRemoteError(gson)
    }

    override fun postKeywordLogs(keyword: String): Completable {
        return api.postKeywordLog("{\"keyword\":\"$keyword\"}".toRequestBody("application/json".toMediaType()))
            .catchRemoteError(gson)
    }
}