package com.rightcode.huespine.remote

import com.rightcode.huespine.data.source.remote.CategoriesRemoteDataSource
import com.rightcode.huespine.remote.mapper.CategoryListMapper
import com.rightcode.huespine.remote.retrofit.api.CategoriesApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import javax.inject.Inject

internal class CategoriesRemoteDataSourceImpl @Inject constructor(
    private val api: CategoriesApi,
    private val gson: Gson
) : CategoriesRemoteDataSource {

    override fun getCategories() = api.getCategories()
        .map(CategoryListMapper::mapToData)
        .catchRemoteError(gson)
}