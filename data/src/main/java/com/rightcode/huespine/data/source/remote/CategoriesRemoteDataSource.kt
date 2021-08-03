package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.CategoryData
import io.reactivex.Single

interface CategoriesRemoteDataSource {

    fun getCategories(): Single<List<CategoryData>>
}
