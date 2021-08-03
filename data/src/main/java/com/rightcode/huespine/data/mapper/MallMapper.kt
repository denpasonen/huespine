package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.MallData
import com.rightcode.huespine.domain.model.Category
import com.rightcode.huespine.domain.model.Mall
import com.rightcode.huespine.domain.model.Source


internal object MallMapper : Mapper<MallData, Mall> {
    override fun mapToDomain(from: MallData): Mall {
        return Mall(
            id = from.id,
            name = from.name,
            path = from.path,
            titleImage = from.titleImage,
            source = sourceMapToData(from.source),
            type = from.type,
            category = categoryMapToData(from.category),
            hashtagIds = from.hashtagIds,
            likedCount = from.likedCount,
            liked = from.liked,
            recommended = from.recommended,
            viewCount = from.viewCount
        )
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