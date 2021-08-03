package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.Category
import io.reactivex.Single

interface CategoriesRepository {
    fun getCategories(): Single<List<Category>>
}