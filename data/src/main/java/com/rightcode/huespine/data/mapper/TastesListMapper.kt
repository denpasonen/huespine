package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.TastesData
import com.rightcode.huespine.domain.model.Tastes


internal object TastesListMapper : Mapper<List<TastesData>, List<Tastes>> {
    override fun mapToDomain(from: List<TastesData>): List<Tastes> {
        return from.map { tastes ->
            Tastes(
                id = tastes.id,
                mallTypeId = tastes.mallTypeId,
                name = tastes.name,
                image = tastes.image,
                order = tastes.order
            )
        }
    }
}