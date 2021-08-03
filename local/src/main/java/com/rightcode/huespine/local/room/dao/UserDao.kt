package com.rightcode.huespine.local.room.dao

import androidx.room.*
import com.rightcode.huespine.local.model.UserEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
internal interface UserDao {

    @Query("SELECT count(*) > 0 FROM user WHERE id = :id LIMIT 1")
    fun existsById(id: Long): Single<Boolean>

    @Transaction
    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    fun findOneBy(id: Long): Flowable<UserEntity>

    @Transaction
    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    fun findOneByIdOnce(id: Long): Single<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity): Single<Long>

    @Query("DELETE FROM user")
    fun deleteAll(): Completable
}