package com.rightcode.huespine.data.source.remote

import io.reactivex.Single

interface FileRemoteDataSource {
    fun uploadImage(
        byteArray: ByteArray,
        mimeType: String
    ): Single<String>

    fun uploadFile(
        byteArray: ByteArray,
        mimeType: String
    ): Single<String>
}