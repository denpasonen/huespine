package com.rightcode.huespine.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
internal data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Long,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "createdAt")
    val createdAt: String,

    @ColumnInfo(name = "profileId")
    val profileId: Int,

    @ColumnInfo(name = "profileName")
    val profileName: String,

    @ColumnInfo(name = "profileImage")
    val profileImage: String

)