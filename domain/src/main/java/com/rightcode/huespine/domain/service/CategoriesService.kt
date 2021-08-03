package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.Category
import io.reactivex.Single

interface CategoriesService {
    fun getCategories(): Single<List<Category>>
}