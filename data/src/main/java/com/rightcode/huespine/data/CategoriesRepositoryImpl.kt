package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.CategoryListMapper
import com.rightcode.huespine.data.source.remote.CategoriesRemoteDataSource
import com.rightcode.huespine.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val remote: CategoriesRemoteDataSource,
) : CategoriesRepository {

    override fun getCategories() = remote.getCategories()
        .map(CategoryListMapper::mapToDomain)

}