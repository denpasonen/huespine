package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.HashtagData
import com.rightcode.huespine.remote.model.response.GetHashtagListResponse

internal object GetHashtagListMapper : Mapper<GetHashtagListResponse, List<HashtagData>> {
    override fun mapToData(from: GetHashtagListResponse): List<HashtagData> {
        return from.data.map { data ->
            HashtagData(
                id = data.id,
                name = data.name
            )
        }
    }
}