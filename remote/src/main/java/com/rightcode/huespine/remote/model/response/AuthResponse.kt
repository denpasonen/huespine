package com.rightcode.huespine.remote.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

internal data class AuthResponse(
    @SerializedName("id")
    @Expose val id: Long,

    @SerializedName("name")
    @Expose val name: String,

    @SerializedName("email")
    @Expose val email: String,

    @SerializedName("createdAt")
    @Expose val createdAt: Date,

    @SerializedName("profile")
    @Expose val profile: Profile
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
