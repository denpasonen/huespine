package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.MallData
import com.rightcode.huespine.domain.model.Category
import com.rightcode.huespine.domain.model.Mall
import com.rightcode.huespine.domain.model.Source

internal object MallListMapper : Mapper<List<MallData>, List<Mall>> {
    override fun mapToDomain(from: List<MallData>): List<Mall> {
        return from.map { mall ->
            Mall(
                id = mall.id,
                name = mall.name,
                path = mall.path,
                titleImage = mall.titleImage,
                source = sourceMapToData(mall.source),
                type = mall.type,
                category = categoryMapToData(mall.category),
                hashtagIds = mall.hashtagIds,
                likedCount = mall.likedCount,
                liked = mall.liked,
                recommended = mall.recommended,
                viewCount = mall.viewCount
            )
        }
    }

    private fun sourceMapToData(from: MallData.Source): Source {
        return Source(from.name, from.url)
    }

    private fun categoryMapToData(from: MallData.Category): Category {
        return Category(
            from.id.toInt(),
            from.parentId?.toInt(),
            from.name,
            from.onboardImage,
            from.image,
            from.enabled,
            from.order.toLong()
        )
    }
}