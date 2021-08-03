package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.ProductData
import io.reactivex.Single


interface HomeRemoteDataSource {

    fun getProducts(): Single<Pair<List<ProductData>, Boolean>>
}
