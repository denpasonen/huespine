package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.LikeListData
import com.rightcode.huespine.domain.model.LikeList


internal object LikeListMapper : Mapper<List<LikeListData>, List<LikeList>> {
    override fun mapToDomain(from: List<LikeListData>): List<LikeList> {
        return from.map { likeList ->
            LikeList(
                id = likeList.id,
                image = likeList.image,
                name = likeList.name
            )
        }
    }
}