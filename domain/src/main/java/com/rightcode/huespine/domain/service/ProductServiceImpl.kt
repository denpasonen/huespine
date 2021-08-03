package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Product
import com.rightcode.huespine.domain.model.type.OrderType
import com.rightcode.huespine.domain.model.type.SortType
import com.rightcode.huespine.domain.repository.ProductRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class ProductServiceImpl @Inject constructor(
    private val productRepository: ProductRepository
) : ProductService {

    override fun getProducts(start: Int, limit: Int): Single<List<Product>> {
        return productRepository.getProducts(start, limit)
    }

    override fun getProduct(id: Long): Single<Product> = productRepository.getProduct(id)

    override fun getProductsFilter(
        filter: String?,
        start: Int,
        limit: Int
    ): Single<Pair<List<Product>, Int>> {
        return productRepository.getProductsFilter(filter, start, limit)
    }

    override fun getProductsCategoryId(
        categoryId: Int?,
        filter: String?,
        sort: SortType,
        minimumPrice: Long?,
        maximumPrice: Long?,
        order: OrderType,
        start: Int,
        limit: Int
    ): Single<List<Product>> {
        return productRepository.getProductsCategoryId(
            categoryId,
            filter,
            sort,
            minimumPrice,
            maximumPrice,
            order,
            start,
            limit
        )
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
        return productRepository.getProductsSearch(
            search,
            filter,
            sort,
            minimumPrice,
            maximumPrice,
            order,
            start,
            limit
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
        return productRepository.getProductsByFilter(
            categoryId,
            filter,
            search,
            minimumPrice,
            maximumPrice,
            sort,
            order,
            start,
            perPage
        )
    }

    override fun updateProductLike(id: Long, isLike: Boolean): Completable {
        return productRepository.updateProductLike(id, isLike)
    }

    override fun getSearchList(): Single<Set<String>> {
        return productRepository.getSearchList()
    }
}