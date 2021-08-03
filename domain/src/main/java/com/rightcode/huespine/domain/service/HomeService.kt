package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Product
import io.reactivex.Single

interface HomeService {

    fun getProducts(): Single<Pair<List<Product>, Boolean>>
}