package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.HashtagData
import com.rightcode.huespine.domain.model.Hashtag

internal object HashTagListMapper : Mapper<List<HashtagData>, List<Hashtag>> {
    override fun mapToDomain(from: List<HashtagData>): List<Hashtag> {
        return from.map { mall ->
            Hashtag(
                id = mall.id,
                name = mall.name
            )
        }
    }
}