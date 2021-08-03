package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Product
import com.rightcode.huespine.domain.model.type.OrderType
import com.rightcode.huespine.domain.model.type.SortType
import io.reactivex.Completable
import io.reactivex.Single

interface ProductService {
    fun getProducts(
        start: Int,
        limit: Int
    ): Single<List<Product>>

    fun getProduct(id: Long): Single<Product>

    fun getProductsFilter(
        filter: String?,
        start: Int,
        limit: Int
    ): Single<Pair<List<Product>, Int>>

    fun getProductsCategoryId(
        categoryId: Int?,
        filter: String?,
        sort: SortType,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderType,
        start: Int,
        limit: Int
    ): Single<List<Product>>

    fun getProductsSearch(
        search: String,
        filter: String?,
        sort: SortType,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderType,
        start: Int,
        limit: Int
    ): Single<List<Product>>

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
    ): Single<Pair<List<Product>, Int>>

    fun updateProductLike(
        id: Long,
        isLike: Boolean
    ): Completable

    fun getSearchList(): Single<Set<String>>
}