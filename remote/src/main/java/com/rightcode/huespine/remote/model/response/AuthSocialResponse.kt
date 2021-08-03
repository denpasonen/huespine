package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

internal data class AuthSocialResponse(
    @SerializedName("user")
    @Expose val user: User
) {
    data class User(
        @SerializedName("id")
        @Expose val id: Long,

        @SerializedName("name")
        @Expose val name: String,

        @SerializedName("level")
        @Expose val level: Int,

        @SerializedName("email")
        @Expose val email: String,

        @SerializedName("createdAt")
        @Expose val createdAt: Date,

        @SerializedName("updatedAt")
        @Expose val updatedAt: Date,

        @SerializedName("agreeMarketing")
        @Expose val agreeMarketing: Boolean,

        @SerializedName("profile")
        @Expose val profile: Profile
    ) {
        data class Profile(
            @SerializedName("id")
            @Expose val id: Int,

            @SerializedName("name")
            @Expose val name: String,

            @SerializedName("image")
            @Expose val image: String,
        )
    }
}
