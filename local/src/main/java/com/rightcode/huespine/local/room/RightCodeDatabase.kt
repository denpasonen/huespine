package com.rightcode.huespine.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rightcode.huespine.local.BuildConfig
import com.rightcode.huespine.local.model.UserEntity
import com.rightcode.huespine.local.room.dao.UserDao

@Database(
    entities = [
        UserEntity::class
    ],
    exportSchema = false,
    version = 1
)
internal abstract class RightCodeDatabase : RoomDatabase() {
    abstract val userDao: UserDao

    companion object {
        private const val DATABASE_NAME = BuildConfig.LIBRARY_PACKAGE_NAME + ".db"
        fun create(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RightCodeDatabase::class.java,
            DATABASE_NAME
        ).addMigrations()
            .build()
    }
}