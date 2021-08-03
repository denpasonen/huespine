package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.CategoryData
import com.rightcode.huespine.domain.model.Category


internal object CategoryListMapper : Mapper<List<CategoryData>, List<Category>> {
    override fun mapToDomain(from: List<CategoryData>): List<Category> {
        return from.map { category ->
            Category(
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