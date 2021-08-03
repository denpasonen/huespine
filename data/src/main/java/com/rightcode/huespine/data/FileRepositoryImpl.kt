package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.FileInfoMapper
import com.rightcode.huespine.data.source.local.FileLocalDataSource
import com.rightcode.huespine.data.source.remote.FileRemoteDataSource
import com.rightcode.huespine.domain.model.FileInfo
import com.rightcode.huespine.domain.repository.FileRepository
import io.reactivex.Single
import javax.inject.Inject

internal class FileRepositoryImpl @Inject constructor(
    private val local: FileLocalDataSource,
    private val remote: FileRemoteDataSource
) : FileRepository {
    override fun uploadPictureImage(path: String): Single<String> {
        return local.getCompressedJpeg(path)
            .flatMap { binaryImage ->
                remote.uploadImage(binaryImage, "image/jpeg")
            }
    }

    override fun getFileInfo(path: String): Single<FileInfo> {
        return local.getFileInfo(path)
            .map(FileInfoMapper::mapToDomain)
    }

}