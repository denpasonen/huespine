package com.rightcode.huespine.data.model.common

import com.rightcode.huespine.data.mapper.EnumMapper
import com.rightcode.huespine.domain.model.type.OrderType

enum class OrderTypeData {
    ASC,
    DESC;

    companion object : EnumMapper<OrderTypeData, OrderType> {
        override fun mapToDomain(from: OrderTypeData): OrderType {
            return when (from) {
                ASC -> OrderType.ASC
                DESC -> OrderType.DESC
            }
        }

        override fun mapFromDomain(from: OrderType): OrderTypeData {
            return when (from) {
                OrderType.ASC -> ASC
                OrderType.DESC -> DESC
            }
        }
    }
}