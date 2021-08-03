package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.ProductData
import com.rightcode.huespine.remote.model.response.GetProductResponse

internal object GetProductMapper : Mapper<GetProductResponse, ProductData> {
    override fun mapToData(from: GetProductResponse): ProductData {
        return ProductData(
            id = from.id,
            mallId = from.mallId,
            crawlerId = from.crawlerId,
            categoryId = from.categoryId,
            category = emptyList(),
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
            mallName = from.mallName,
            liked = from.liked,
            mallLiked = from.mallLiked
        )
    }
}
