package com.rightcode.huespine.domain.repository

import com.rightcode.huespine.domain.model.FileInfo
import io.reactivex.Single

interface FileRepository {
    fun uploadPictureImage(
        path: String
    ): Single<String>

    fun getFileInfo(path: String): Single<FileInfo>
}