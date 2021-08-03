package com.rightcode.huespine.data.source.local

import com.rightcode.huespine.data.model.FileInfoData
import io.reactivex.Single

interface FileLocalDataSource {
    fun getCompressedJpeg(
        path: String
    ): Single<ByteArray>

    fun getFileInfo(
        path: String
    ): Single<FileInfoData>
}