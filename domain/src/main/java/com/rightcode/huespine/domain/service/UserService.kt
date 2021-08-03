package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

interface UserService {
    fun fetchUser(): Flowable<Optional<User>>

    fun getCategories(): Single<List<Category>>

    fun getProfileCharacters(): Single<List<ProfileCharacters>>

    fun getTastes(): Single<List<Tastes>>

    fun getUsers(userId: Long): Single<User>

    fun getUserProfile(userId: Long): Single<UserProfile>

    fun updateName(name: String): Completable

    fun updateProfileCharacter(profile: ProfileCharacters?): Completable

    fun updateTaste(tasteIds: List<Int>): Completable

    fun updateCategory(categoryIds: List<Int>): Completable

    fun getUser(): Single<UserProfile>

    fun updatePassword(currentPassword: String, password: String): Completable

}