package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.LikeListData
import com.rightcode.huespine.remote.model.response.GetPostLikeListResponse
import com.rightcode.huespine.remote.model.response.GetUserProductLikeListResponse

internal object GetPostLikeListMapper :
    Mapper<List<GetPostLikeListResponse>, List<LikeListData>> {
    override fun mapToData(from: List<GetPostLikeListResponse>): List<LikeListData> {
        return from.map { data ->
            LikeListData(
                id = data.id,
                name = data.name,
                image = data.image
            )
        }
    }
}