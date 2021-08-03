package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.MallTypeData
import com.rightcode.huespine.domain.model.MallType


internal object MallTypeMapper : Mapper<MallTypeData, MallType> {
    override fun mapToDomain(from: MallTypeData): MallType {
        return MallType(
            id = from.id,
            name = from.name
        )
    }
}