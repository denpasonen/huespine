package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.HashtagData
import com.rightcode.huespine.remote.model.response.GetHashtagResponse

internal object GetHashtagMapper : Mapper<GetHashtagResponse, HashtagData> {
    override fun mapToData(from: GetHashtagResponse): HashtagData {
        return HashtagData(
            id = from.id,
            name = from.name
        )
    }
}