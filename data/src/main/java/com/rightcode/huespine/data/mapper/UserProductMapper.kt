package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.UserProductData
import com.rightcode.huespine.domain.model.UserProduct

internal object UserProductMapper : Mapper<UserProductData, UserProduct> {
    override fun mapToDomain(from: UserProductData): UserProduct {
        return UserProduct(
            id = from.id,
            userId = from.userId,
            type = when (from.type) {
                UserProductData.Type.SELL -> UserProduct.Type.SELL
                UserProductData.Type.BUY -> UserProduct.Type.BUY
                UserProductData.Type.AUCTION -> UserProduct.Type.AUCTION
                UserProductData.Type.SHARE -> UserProduct.Type.SHARE
                UserProductData.Type.NONE -> UserProduct.Type.NONE
            },
            status = when (from.status) {
                UserProductData.Status.NONE -> UserProduct.Status.NONE
                UserProductData.Status.ING -> UserProduct.Status.ING
                UserProductData.Status.DONE -> UserProduct.Status.DONE
            },
            dealType = from.dealType?.map { dealType ->
                when (dealType) {
                    UserProductData.DealType.NONE -> UserProduct.DealType.NONE
                    UserProductData.DealType.DIRECT -> UserProduct.DealType.DIRECT
                    UserProductData.DealType.POST -> UserProduct.DealType.POST
                    UserProductData.DealType.DELIVERY -> UserProduct.DealType.DELIVERY
                }
            },
            title = from.title,
            description = from.description,
            images = from.images,
            price = from.price,
            endAt = from.endAt,
            likedCount = from.likedCount,
            commentCount = from.commentCount,
            createdAt = from.createdAt,
            updatedAt = from.updatedAt,
            profileName = from.profileName,
            profileImage = from.profileImage,
            liked = from.liked == true,
            freeShipping = from.freeShipping
        )
    }
}
