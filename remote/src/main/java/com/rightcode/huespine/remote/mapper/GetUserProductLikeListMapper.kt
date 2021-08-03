package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.LikeListData
import com.rightcode.huespine.remote.model.response.GetUserProductLikeListResponse

internal object GetUserProductLikeListMapper :
    Mapper<List<GetUserProductLikeListResponse>, List<LikeListData>> {
    override fun mapToData(from: List<GetUserProductLikeListResponse>): List<LikeListData> {
        return from.map { data ->
            LikeListData(
                id = data.id,
                name = data.name,
                image = data.image
            )
        }
    }
}