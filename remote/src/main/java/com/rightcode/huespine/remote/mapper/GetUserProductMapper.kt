package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.UserProductData
import com.rightcode.huespine.remote.model.response.GetUserProductResponse
import com.rightcode.huespine.remote.utils.enumValueOrNull

internal object GetUserProductMapper :
    Mapper<GetUserProductResponse, UserProductData> {
    override fun mapToData(from: GetUserProductResponse): UserProductData {
        return UserProductData(
            id = from.id,
            userId = from.userId,
            type = from.type.enumValueOrNull() ?: UserProductData.Type.NONE,
            status = from.status.enumValueOrNull() ?: UserProductData.Status.NONE,
            dealType = from.dealType?.map {
                it.enumValueOrNull() ?: UserProductData.DealType.NONE
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
            liked = from.liked,
            freeShipping = from.freeShipping
        )
    }
}
