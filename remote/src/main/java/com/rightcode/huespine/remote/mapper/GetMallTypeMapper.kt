package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.MallTypeData
import com.rightcode.huespine.remote.model.response.GetMallTypeResponse

internal object GetMallTypeMapper : Mapper<GetMallTypeResponse, MallTypeData> {
    override fun mapToData(from: GetMallTypeResponse): MallTypeData {
        return MallTypeData(
            id = from.id,
            name = from.name
        )
    }
}