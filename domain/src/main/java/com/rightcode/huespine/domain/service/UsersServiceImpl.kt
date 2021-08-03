package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.ProfileCharacters
import com.rightcode.huespine.domain.model.Tastes
import com.rightcode.huespine.domain.model.User
import com.rightcode.huespine.domain.model.UserProfile
import com.rightcode.huespine.domain.repository.UserRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class UsersServiceImpl @Inject constructor(
    private val usersRepository: UserRepository
) : UserService {
    override fun fetchUser() = usersRepository.fetchUser()

    override fun getCategories() = usersRepository.getCategories()

    override fun getProfileCharacters() = usersRepository.getProfileCharacters()

    override fun getTastes(): Single<List<Tastes>> = usersRepository.getTastes()

    override fun getUsers(userId: Long): Single<User> = usersRepository.getUser(userId)

    override fun getUserProfile(userId: Long): Single<UserProfile> =
        usersRepository.getUserProfile(userId)

    override fun updateName(name: String) = usersRepository.updateName(name)

    override fun updateProfileCharacter(profile: ProfileCharacters?) =
        usersRepository.updateProfileCharacter(
            profile?.id ?: 0,
            profile?.image ?: "",
            profile?.name ?: ""
        )

    override fun updateTaste(tasteIds: List<Int>) = usersRepository.updateTaste(tasteIds)

    override fun updateCategory(categoryIds: List<Int>) =
        usersRepository.updateCategory(categoryIds)

    override fun getUser(): Single<UserProfile> = usersRepository.getUser()

    override fun updatePassword(currentPassword: String, password: String): Completable =
        usersRepository.updatePassword(currentPassword, password)
}