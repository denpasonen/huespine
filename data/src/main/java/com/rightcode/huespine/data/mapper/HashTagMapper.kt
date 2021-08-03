package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.HashtagData
import com.rightcode.huespine.domain.model.Hashtag


internal object HashTagMapper : Mapper<HashtagData, Hashtag> {
    override fun mapToDomain(from: HashtagData): Hashtag {
        return Hashtag(
            id = from.id,
            name = from.name
        )
    }
}