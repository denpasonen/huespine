package com.rightcode.huespine.remote

import com.rightcode.huespine.data.source.remote.FileRemoteDataSource
import com.rightcode.huespine.remote.model.request.FileType
import com.rightcode.huespine.remote.retrofit.api.FileApi
import com.rightcode.huespine.remote.retrofit.api.UploadApi
import com.rightcode.huespine.remote.utils.rx.catchRemoteError
import com.google.gson.Gson
import io.reactivex.Single
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

internal class FileRemoteDataSourceImpl @Inject constructor(
    private val fileApi: FileApi,
    private val uploadApi: UploadApi,
    private val gson: Gson
) : FileRemoteDataSource {
    override fun uploadImage(
        byteArray: ByteArray,
        mimeType: String
    ): Single<String> {
        return uploadFile(
            type = FileType.IMAGE,
            byteArray = byteArray,
            mimeType = mimeType
        )
    }

    override fun uploadFile(byteArray: ByteArray, mimeType: String): Single<String> {
        return uploadFile(
            type = FileType.FILE,
            byteArray = byteArray,
            mimeType = mimeType
        )
    }

    private fun uploadFile(
        type: FileType,
        byteArray: ByteArray,
        mimeType: String
    ): Single<String> {
        return fileApi.getFileUploadUrl(
            type = type,
            mimeType = mimeType
        ).flatMap { (path, url) ->
            uploadApi.putFile(
                url,
                byteArray.toRequestBody(
                    contentType = mimeType.toMediaTypeOrNull()
                )
            ).andThen(Single.just(path))
        }.catchRemoteError(gson)
    }
}