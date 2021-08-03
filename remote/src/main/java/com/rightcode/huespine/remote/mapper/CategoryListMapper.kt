package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.CategoryData
import com.rightcode.huespine.remote.model.response.CategoryListResponse

internal object CategoryListMapper : Mapper<CategoryListResponse, List<CategoryData>> {
    override fun mapToData(from: CategoryListResponse): List<CategoryData> {
        return from.data.sortedBy {
            it.order
        }.map { category ->
            CategoryData(
                id = category.id,
                parentId = category.parentId,
                name = category.name,
                onboardImage = category.onboardImage,
                image = category.image,
                order = category.order,
                createdAt = category.createdAt
            )
        }
    }
}