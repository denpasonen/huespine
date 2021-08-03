package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.MallData
import com.rightcode.huespine.remote.model.response.GetMallResponse

internal object GetMallMapper : Mapper<GetMallResponse, MallData> {
    override fun mapToData(from: GetMallResponse): MallData {
        return MallData(
            id = from.id,
            name = from.name,
            path = from.path,
            titleImage = from.titleImage,
            source = from.source?.let { sourceMapToData(from.source) },
            type = from.type,
            category = categoryMapToData(from.category),
            hashtagIds = from.hashtagIds,
            likedCount = from.likedCount,
            liked = from.liked,
            recommended = from.recommended,
            viewCount = from.viewCount
        )
    }

    private fun sourceMapToData(from: GetMallResponse.Source): MallData.Source {
        return MallData.Source(from.name, from.url)
    }

    private fun categoryMapToData(from: GetMallResponse.Category): MallData.Category {
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