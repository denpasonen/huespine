package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.ProductData
import com.rightcode.huespine.domain.model.Product


internal object ProductMapper : Mapper<ProductData, Product> {
    override fun mapToDomain(from: ProductData): Product {
        return Product(
            id = from.id,
            mallId = from.mallId,
            crawlerId = from.crawlerId,
            categoryId = from.categoryId,
            category = from.category,
            name = from.name,
            price = from.price,
            discountRate = from.discountRate,
            originalPrice = from.originalPrice,
            onSale = from.onSale,
            pinned = from.pinned,
            soldOut = from.soldOut,
            likedCount = from.likedCount,
            titleImage = from.titleImage,
            images = from.images,
            sourceUrl = from.sourceUrl,
            createdAt = from.createdAt,
            updatedAt = from.updatedAt,
            mallName = from.mallName ?: "",
            liked = from.liked,
            mallLiked = from.mallLiked
        )
    }
}
