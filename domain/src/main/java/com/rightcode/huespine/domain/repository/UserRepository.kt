package com.rightcode.huespine.domain.repository


import com.rightcode.huespine.domain.model.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

interface UserRepository {

    fun fetchUser(): Flowable<Optional<User>>

    fun getCategories(): Single<List<Category>>

    fun getProfileCharacters(): Single<List<ProfileCharacters>>

    fun getTastes(): Single<List<Tastes>>

    fun getUser(userId: Long): Single<User>

    fun save(user: User): Completable

    fun getUserProfile(userId: Long): Single<UserProfile>

    fun updateName(name: String): Completable

    fun updateProfileCharacter(profileId: Int, profileUrl:String, profileName:String): Completable

    fun updateTaste(tasteIds: List<Int>): Completable

    fun updateCategory(categoryIds: List<Int>): Completable

    fun getUser(): Single<UserProfile>

    fun updatePassword(currentPassword: String, password: String): Completable


}