package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.UserProductData
import com.rightcode.huespine.domain.model.UserProduct

internal object UserProductListMapper : Mapper<List<UserProductData>, List<UserProduct>> {
    override fun mapToDomain(from: List<UserProductData>): List<UserProduct> {
        return from.map { product ->
            UserProduct(
                id = product.id,
                userId = product.userId,
                type = when (product.type) {
                    UserProductData.Type.SELL -> UserProduct.Type.SELL
                    UserProductData.Type.BUY -> UserProduct.Type.BUY
                    UserProductData.Type.AUCTION -> UserProduct.Type.AUCTION
                    UserProductData.Type.SHARE -> UserProduct.Type.SHARE
                    UserProductData.Type.NONE -> UserProduct.Type.NONE
                },
                status = when (product.status) {
                    UserProductData.Status.NONE -> UserProduct.Status.NONE
                    UserProductData.Status.ING -> UserProduct.Status.ING
                    UserProductData.Status.DONE -> UserProduct.Status.DONE
                },
                dealType = product.dealType?.map { dealType ->
                    when (dealType) {
                        UserProductData.DealType.NONE -> UserProduct.DealType.NONE
                        UserProductData.DealType.DELIVERY -> UserProduct.DealType.DELIVERY
                        UserProductData.DealType.POST -> UserProduct.DealType.POST
                        UserProductData.DealType.DIRECT -> UserProduct.DealType.DIRECT
                    }
                },
                title = product.title,
                description = product.description,
                images = product.images,
                price = product.price,
                endAt = product.endAt,
                likedCount = product.likedCount,
                commentCount = product.commentCount,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt,
                profileName = product.profileName,
                profileImage = product.profileImage,
                liked = product.liked == true,
                freeShipping = product.freeShipping
            )
        }
    }
}