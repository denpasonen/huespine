package com.rightcode.huespine.remote.mapper

import com.rightcode.huespine.data.model.KeywordData
import com.rightcode.huespine.remote.model.response.GetKeywordListResponse

internal object GetKeywordListMapper : Mapper<GetKeywordListResponse, List<KeywordData>> {
    override fun mapToData(from: GetKeywordListResponse): List<KeywordData> {
        return from.data.map {
            KeywordData(it.id, it.keyword)
        }
    }
}