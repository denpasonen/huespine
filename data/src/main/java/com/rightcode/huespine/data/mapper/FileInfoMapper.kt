package com.rightcode.huespine.data.mapper

import com.rightcode.huespine.data.model.FileInfoData
import com.rightcode.huespine.domain.model.FileInfo

object FileInfoMapper : Mapper<FileInfoData, FileInfo> {
    override fun mapToDomain(from: FileInfoData): FileInfo {
        return FileInfo(
            path = from.path,
            name = from.name
        )
    }
}