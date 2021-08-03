package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.response.CategoryListResponse
import io.reactivex.Single
import retrofit2.http.GET

internal interface CategoriesApi {

    @GET("categories")
    fun getCategories(): Single<CategoryListResponse>
}