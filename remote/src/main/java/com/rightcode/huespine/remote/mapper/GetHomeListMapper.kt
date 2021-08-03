package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.ProductData
import com.rightcode.huespine.remote.model.response.GetHomeProductResponse

internal object GetHomeListMapper : Mapper<GetHomeProductResponse, List<ProductData>> {
    override fun mapToData(from: GetHomeProductResponse): List<ProductData> {
        return from.data.map { data ->
            ProductData(
                id = data.id,
                mallId = data.mallId,
                crawlerId = data.crawlerId,
                categoryId = data.categoryId,
                category = emptyList(),
                name = data.name,
                price = data.price,
                discountRate = data.discountRate,
                originalPrice = data.originalPrice,
                onSale = data.onSale,
                pinned = data.pinned,
                soldOut = data.soldOut,
                likedCount = data.likedCount,
                titleImage = data.titleImage,
                images = data.images,
                sourceUrl = data.sourceUrl,
                createdAt = data.createdAt,
                updatedAt = data.updatedAt,
                mallName = data.mallName,
                liked = data.liked,
                mallLiked = data.mallLiked
            )
        }
    }


}