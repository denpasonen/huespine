package com.rightcode.huespine.remote.retrofit.api

import com.rightcode.huespine.remote.model.request.FileType
import com.rightcode.huespine.remote.model.response.GetFileUploadResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

internal interface FileApi {
    @GET("files/upload")
    fun getFileUploadUrl(
        @Query("type")
        type: FileType,

        @Query("mimeType")
        mimeType: String
    ): Single<GetFileUploadResponse>
}