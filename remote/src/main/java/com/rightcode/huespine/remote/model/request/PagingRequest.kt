package com.rightcode.huespine.remote.model.request

import com.rightcode.huespine.data.model.common.OrderTypeData
import com.rightcode.huespine.data.model.common.SortTypeData
import com.rightcode.huespine.remote.mapper.EnumMapper
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal enum class Sort {
    @SerializedName("createdAt")
    @Expose
    CREATED_AT,

    @SerializedName("name")
    @Expose
    NAME,

    @SerializedName("price")
    @Expose
    PRICE,

    @SerializedName("popularity")
    @Expose
    POPULARITY;

    companion object : EnumMapper<Sort, SortTypeData> {
        override fun mapToData(from: Sort): SortTypeData {
            return when (from) {
                CREATED_AT -> SortTypeData.CREATED_AT
                NAME -> SortTypeData.NAME
                PRICE -> SortTypeData.PRICE
                POPULARITY -> SortTypeData.POPULARITY
            }
        }

        override fun mapFromData(from: SortTypeData): Sort {
            return when (from) {
                SortTypeData.CREATED_AT -> CREATED_AT
                SortTypeData.NAME -> NAME
                SortTypeData.PRICE -> PRICE
                SortTypeData.POPULARITY -> POPULARITY
            }
        }
    }
}

internal enum class Order {
    @SerializedName("ASC")
    @Expose
    ASC,

    @SerializedName("DESC")
    @Expose
    DESC;

    companion object : EnumMapper<Order, OrderTypeData> {
        override fun mapToData(from: Order): OrderTypeData {
            return when (from) {
                ASC -> OrderTypeData.ASC
                DESC -> OrderTypeData.DESC
            }
        }

        override fun mapFromData(from: OrderTypeData): Order {
            return when (from) {
                OrderTypeData.ASC -> ASC
                OrderTypeData.DESC -> DESC
            }
        }
    }
}