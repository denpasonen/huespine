package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.ProductListMapper
import com.rightcode.huespine.data.source.remote.HomeRemoteDataSource
import com.rightcode.huespine.domain.model.Product
import com.rightcode.huespine.domain.repository.HomeRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remote: HomeRemoteDataSource
) : HomeRepository {
    override fun getProducts(): Single<Pair<List<Product>, Boolean>> {
        return remote.getProducts()
            .map { (list, isNew) ->
                ProductListMapper.mapToDomain(list) to isNew
            }
    }
}