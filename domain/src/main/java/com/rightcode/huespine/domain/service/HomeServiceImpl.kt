package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Product
import com.rightcode.huespine.domain.repository.HomeRepository
import io.reactivex.Single
import javax.inject.Inject

class HomeServiceImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : HomeService {

    override fun getProducts(): Single<Pair<List<Product>, Boolean>> {
        return homeRepository.getProducts()
    }
}