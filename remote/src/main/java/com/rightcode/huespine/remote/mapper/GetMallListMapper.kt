package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.MallData
import com.rightcode.huespine.remote.model.response.GetMallListResponse

internal object GetMallListMapper : Mapper<GetMallListResponse, List<MallData>> {
    override fun mapToData(from: GetMallListResponse): List<MallData> {
        return from.data.map { data ->
            MallData(
                id = data.id,
                name = data.name,
                path = data.path,
                titleImage = data.titleImage,
                source = data.source?.let { sourceMapToData(it) },
                type = data.type,
                category = categoryMapToData(data.category),
                hashtagIds = data.hashtagIds,
                likedCount = data.likedCount,
                liked = data.liked,
                recommended = data.recommended,
                viewCount = data.viewCount
            )
        }
    }

    private fun sourceMapToData(from: GetMallListResponse.Data.Source): MallData.Source {
        return MallData.Source(from.name, from.url)
    }

    private fun categoryMapToData(from: GetMallListResponse.Data.Category): MallData.Category {
        return MallData.Category(
            from.id,
            from.parentId,
            from.name,
            from.onboardImage,
            from.image,
            from.enabled,
            from.order
        )
    }
}