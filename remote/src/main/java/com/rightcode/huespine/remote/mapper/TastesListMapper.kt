package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.TastesData
import com.rightcode.huespine.remote.model.response.TastesListResponse

internal object TastesListMapper : Mapper<TastesListResponse, List<TastesData>> {
    override fun mapToData(from: TastesListResponse): List<TastesData> {
        return from.data.map { tastes ->
            TastesData(
                id = tastes.id,
                mallTypeId = tastes.mallTypeId,
                name = tastes.name,
                image = tastes.image,
                order = tastes.order
            )
        }
    }
}