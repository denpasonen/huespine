package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.ProductData
import com.rightcode.huespine.domain.model.Product


internal object ProductListMapper : Mapper<List<ProductData>, List<Product>> {
    override fun mapToDomain(from: List<ProductData>): List<Product> {
        return from.map { product ->
            Product(
                id = product.id,
                mallId = product.mallId,
                crawlerId = product.crawlerId,
                categoryId = product.categoryId,
                category = product.category,
                name = product.name,
                price = product.price,
                discountRate = product.discountRate,
                originalPrice = product.originalPrice,
                onSale = product.onSale,
                pinned = product.pinned,
                soldOut = product.soldOut,
                likedCount = product.likedCount,
                titleImage = product.titleImage,
                images = product.images,
                sourceUrl = product.sourceUrl,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt,
                mallName = product.mallName ?: "",
                liked = product.liked,
                mallLiked = product.mallLiked
            )
        }
    }
}