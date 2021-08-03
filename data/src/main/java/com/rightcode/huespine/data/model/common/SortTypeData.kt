package com.rightcode.huespine.data.model.common

import com.rightcode.huespine.data.mapper.EnumMapper
import com.rightcode.huespine.domain.model.type.SortType

enum class SortTypeData {
    CREATED_AT,
    NAME,
    PRICE,
    POPULARITY;

    companion object : EnumMapper<SortTypeData, SortType> {
        override fun mapToDomain(from: SortTypeData): SortType {
            return when (from) {
                CREATED_AT -> SortType.CREATED_AT
                NAME -> SortType.NAME
                PRICE -> SortType.PRICE
                POPULARITY -> SortType.POPULARITY
            }
        }

        override fun mapFromDomain(from: SortType): SortTypeData {
            return when (from) {
                SortType.CREATED_AT -> CREATED_AT
                SortType.NAME -> NAME
                SortType.PRICE -> PRICE
                SortType.POPULARITY -> POPULARITY
            }
        }
    }
}