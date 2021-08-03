package com.rightcode.huespine.data.source.remote

import com.rightcode.huespine.data.model.CategoryData
import com.rightcode.huespine.data.model.ProfileCharactersData
import com.rightcode.huespine.data.model.TastesData
import com.rightcode.huespine.data.model.UserProfileData
import io.reactivex.Completable
import io.reactivex.Single


interface UserRemoteDataSource {

    fun getCategories(): Single<List<CategoryData>>

    fun getProfileCharacters(): Single<List<ProfileCharactersData>>

    fun getTastes(): Single<List<TastesData>>

    fun getUserProfile(id: Long): Single<UserProfileData>

    fun updateName(name: String): Completable

    fun updateProfileCharacter(profileId: Int): Completable

    fun updateTaste(tasteIds: List<Int>): Completable

    fun updateCategory(categoryIds: List<Int>): Completable

    fun getUser(): Single<UserProfileData>

    fun updatePassword(currentPassword: String, password: String): Completable

}
