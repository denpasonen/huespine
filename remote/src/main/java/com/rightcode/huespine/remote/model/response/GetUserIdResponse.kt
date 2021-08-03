package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

internal data class GetUserIdResponse(
    @SerializedName("id")
    @Expose val id: Long,

    @SerializedName("name")
    @Expose val name: String,

    @SerializedName("email")
    @Expose val email: String,

    @SerializedName("createdAt")
    @Expose val createdAt: Date,

    @SerializedName("profile")
    @Expose val profile: Profile,

    @SerializedName("level")
    @Expose val level: Int,

    @SerializedName("likeCount")
    @Expose val likeCount: Int,

    @SerializedName("postCount")
    @Expose val postCount: Int,

    @SerializedName("tastes")
    @Expose val tastes: List<Int>,

    @SerializedName("category")
    @Expose val category: List<Int>
) {
    data class Profile(
        @SerializedName("id")
        @Expose val id: Int,

        @SerializedName("name")
        @Expose val name: String,

        @SerializedName("image")
        @Expose val image: String
    )
}
