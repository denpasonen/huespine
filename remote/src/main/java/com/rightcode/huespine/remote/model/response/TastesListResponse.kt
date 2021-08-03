package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal data class TastesListResponse(

    @SerializedName("data")
    @Expose
    val data: List<TastesResponse>,

    @SerializedName("total")
    @Expose
    val total: Int
) {
    data class TastesResponse(
        @SerializedName("id")
        @Expose
        val id: Int,
        @SerializedName("mallTypeId")
        @Expose
        val mallTypeId: Int,

        @SerializedName("name")
        @Expose
        val name: String,

        @SerializedName("image")
        @Expose
        val image: String,
        @SerializedName("order")
        @Expose
        val order: Long,
    )
}
