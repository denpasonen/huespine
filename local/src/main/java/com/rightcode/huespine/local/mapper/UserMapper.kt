package com.rightcode.huespine.local.mapper

import com.rightcode.huespine.data.model.UserData
import com.rightcode.huespine.local.model.UserEntity
import java.text.SimpleDateFormat
import java.util.*


internal object UserMapper : Mapper<UserEntity, UserData> {
    override fun mapToData(from: UserEntity): UserData {
        return UserData( // 이거 안씀
            id = from.id,
            name = from.name,
            email = from.email,
            createdAt = StringToDate(from.createdAt),
            profileId = from.profileId,
            profileName = from.profileName,
            profileImage = from.profileImage
        )
    }

    override fun mapToLocal(from: UserData): UserEntity {
        return UserEntity(
            id = from.id,
            name = from.name,
            email = from.email,
            createdAt = from.createdAt.toString(),
            profileId = from.profileId,
            profileName = from.profileName,
            profileImage = from.profileImage
        )
    }

    private fun StringToDate(createdAt: String): Date {
        return try {
            val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            format.parse(createdAt)
        } catch (ignored: Exception) {
            Date()
        }
    }
}