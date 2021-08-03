package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.ProductListMapper
import com.rightcode.huespine.data.mapper.ProductMapper
import com.rightcode.huespine.data.model.common.OrderTypeData
import com.rightcode.huespine.data.model.common.SortTypeData
import com.rightcode.huespine.data.source.local.SearchLocalDataSource
import com.rightcode.huespine.data.source.remote.ProductRemoteDataSource
import com.rightcode.huespine.domain.model.Product
import com.rightcode.huespine.domain.model.type.OrderType
import com.rightcode.huespine.domain.model.type.SortType
import com.rightcode.huespine.domain.repository.ProductRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val local: SearchLocalDataSource,
    private val remote: ProductRemoteDataSource
) : ProductRepository {
    override fun getProducts(start: Int, limit: Int): Single<List<Product>> {
        return remote.getProducts(start, limit)
            .map(ProductListMapper::mapToDomain)
    }

    override fun getProduct(id: Long): Single<Product> = remote.getProductId(id)
        .map(ProductMapper::mapToDomain)

    override fun getProductsFilter(
        filter: String?,
        start: Int,
        limit: Int
    ): Single<Pair<List<Product>, Int>> {
        return remote.getProductsFilter(filter, start, limit)
            .map { (list, total) ->
                ProductListMapper.mapToDomain(list) to total
            }
    }

    override fun getProductsCategoryId(
        categoryId: Int?,
        filter: String?,
        sort: SortType,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderType, start: Int, limit: Int
    ): Single<List<Product>> {
        return remote.getProductsCategoryId(
            categoryId,
            filter,
            SortTypeData.mapFromDomain(sort),
            minimumPrice,
            maximumPrice,
            OrderTypeData.mapFromDomain(order),
            start,
            limit
        ).map(ProductListMapper::mapToDomain)
    }

    override fun getProductsSearch(
        search: String,
        filter: String?,
        sort: SortType,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderType,
        start: Int,
        limit: Int
    ): Single<List<Product>> {
        return local.save(search)
            .andThen(remote.postKeywordLogs(search))
            .andThen(
                remote.getProductsSearch(
                    search,
                    filter,
                    SortTypeData.mapFromDomain(sort),
                    minimumPrice,
                    maximumPrice,
                    OrderTypeData.mapFromDomain(order),
                    start,
                    limit
                ).map(ProductListMapper::mapToDomain)
            )
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
    ): Single<Pair<List<Product>, Int>> {
        return remote.getProductsByFilter(
            categoryId,
            filter,
            search,
            minimumPrice,
            maximumPrice,
            sort,
            order,
            start,
            perPage
        ).map { response ->
            ProductListMapper.mapToDomain(response.first) to response.second
        }
    }


    override fun updateProductLike(id: Long, isLike: Boolean): Completable {
        return remote.updateProductLike(id, isLike)
    }

    override fun getSearchList(): Single<Set<String>> {
        return Single.just(local.searchList)
    }

}