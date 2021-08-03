package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

internal data class ProfileCharactersListResponse(

    @SerializedName("data")
    @Expose
    val data: List<ProfileCharactersResponse>,

    @SerializedName("total")
    @Expose
    val total: Int
) {
    data class ProfileCharactersResponse(
        @SerializedName("id")
        @Expose
        val id: Int,

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
