package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.MallTypeData
import com.rightcode.huespine.remote.model.response.GetMallTypeListResponse

internal object GetMallTypeListMapper : Mapper<GetMallTypeListResponse, List<MallTypeData>> {
    override fun mapToData(from: GetMallTypeListResponse): List<MallTypeData> {
        return from.data.map { data ->
            MallTypeData(
                id = data.id,
                name = data.name
            )
        }
    }
}