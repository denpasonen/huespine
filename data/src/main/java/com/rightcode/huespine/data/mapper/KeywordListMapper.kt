package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.KeywordData
import com.rightcode.huespine.domain.model.Keyword


internal object KeywordListMapper : Mapper<List<KeywordData>, List<Keyword>> {
    override fun mapToDomain(from: List<KeywordData>): List<Keyword> {
        return from.map { keyword ->
            Keyword(
                id = keyword.id,
                keyword = keyword.keyword
            )
        }
    }
}