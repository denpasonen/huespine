package com.rightcode.huespine.data

import com.rightcode.huespine.data.mapper.*
import com.rightcode.huespine.data.model.UserData
import com.rightcode.huespine.data.source.local.UserLocalDataSource
import com.rightcode.huespine.data.source.remote.UserRemoteDataSource
import com.rightcode.huespine.domain.model.Tastes
import com.rightcode.huespine.domain.model.User
import com.rightcode.huespine.domain.model.UserProfile
import com.rightcode.huespine.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val local: UserLocalDataSource,
    private val remote: UserRemoteDataSource
) : UserRepository {

    override fun fetchUser(): Flowable<Optional<User>> {
        val user = local.getCurrentUser()
        return user
            .map {
                if (it.isPresent) {
                    Optional.of(UserMapper.mapToDomain(it.get()))
                } else {
                    Optional.empty<User>()
                }
            }
    }

    override fun getCategories() = remote.getCategories()
        .map(CategoryListMapper::mapToDomain)

    override fun getProfileCharacters() = remote.getProfileCharacters()
        .map(ProfileCharactersListMapper::mapToDomain)

    override fun getTastes(): Single<List<Tastes>> = remote.getTastes()
        .map(TastesListMapper::mapToDomain)

    override fun getUser(userId: Long): Single<User> = local.getUser(userId)
        .map(UserMapper::mapToDomain)

    override fun getUser(): Single<UserProfile> = remote.getUser()
        .map(UserProfileMapper::mapToDomain).doOnSuccess { user ->
            local.save(
                UserData(
                    id = user.id,
                    name = user.name,
                    email = user.email,
                    createdAt = user.createdAt,
                    profileId = user.profileId,
                    profileName = user.profileName,
                    profileImage = user.profileImage
                )
            )
        }

    override fun save(
        user: User
    ): Completable {
        return local.save(
            UserData(
                id = user.id,
                name = user.name,
                email = user.email,
                createdAt = user.createdAt,
                profileId = user.profileId,
                profileName = user.profileName,
                profileImage = user.profileImage
            )
        )
    }

    override fun getUserProfile(userId: Long): Single<UserProfile> {
        return remote.getUserProfile(userId)
            .map(UserProfileMapper::mapToDomain)
    }

    override fun updateName(name: String): Completable {
        return local.getCurrentUser()
            .firstOrError()
            .flatMapCompletable { user ->
                remote.updateName(name)
                    .andThen(local.save(user.get().copy(name = name)))
            }
    }

    override fun updateProfileCharacter(
        profileId: Int,
        profileUrl: String,
        profileName: String
    ): Completable {
        return local.getCurrentUser()
            .firstOrError()
            .flatMapCompletable { user ->
                remote.updateProfileCharacter(profileId)
                    .andThen(
                        local.save(
                            user.get().copy(
                                profileId = profileId,
                                profileImage = profileUrl,
                                profileName = profileName
                            )
                        )
                    )
            }
    }

    override fun updateTaste(tasteIds: List<Int>): Completable {
        return remote.updateTaste(tasteIds)
    }

    override fun updateCategory(categoryIds: List<Int>): Completable {
        return remote.updateCategory(categoryIds)
    }

    override fun updatePassword(currentPassword: String, password: String): Completable {
        return remote.updatePassword(currentPassword, password)
    }


}