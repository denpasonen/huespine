package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesServiceImpl @Inject constructor(
    private val categoriesRepository: CategoriesRepository,
) : CategoriesService {

    override fun getCategories() = categoriesRepository.getCategories()
}