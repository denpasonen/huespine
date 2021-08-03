package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.Product
import io.reactivex.Single

interface HomeRepository {
    fun getProducts(): Single<Pair<List<Product>, Boolean>>
}