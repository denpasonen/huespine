package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.MallTypeData
import com.rightcode.huespine.domain.model.MallType


internal object MallTypeListMapper : Mapper<List<MallTypeData>, List<MallType>> {
    override fun mapToDomain(from: List<MallTypeData>): List<MallType> {
        return from.map { mall ->
            MallType(
                id = mall.id,
                name = mall.name
            )
        }
    }
}