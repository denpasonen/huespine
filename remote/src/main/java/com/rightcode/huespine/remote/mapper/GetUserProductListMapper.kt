package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.UserProductData
import com.rightcode.huespine.remote.model.response.GetUserProductListResponse
import com.rightcode.huespine.remote.utils.enumValueOrNull

internal object GetUserProductListMapper :
    Mapper<GetUserProductListResponse, List<UserProductData>> {
    override fun mapToData(from: GetUserProductListResponse): List<UserProductData> {
        return from.data.map { data ->
            UserProductData(
                id = data.id,
                userId = data.userId,
                type = data.type.enumValueOrNull() ?: UserProductData.Type.NONE,
                status = data.status.enumValueOrNull() ?: UserProductData.Status.NONE,
                dealType = data.dealType?.map {
                    it.enumValueOrNull() ?: UserProductData.DealType.NONE
                },
                title = data.title,
                description = data.description,
                images = data.images,
                price = data.price,
                endAt = data.endAt,
                likedCount = data.likedCount,
                commentCount = data.commentCount,
                createdAt = data.createdAt,
                updatedAt = data.updatedAt,
                profileName = data.profileName,
                profileImage = data.profileImage,
                liked = data.liked,
                freeShipping = data.freeShipping
            )
        }
    }
}