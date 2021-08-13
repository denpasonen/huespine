package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.model.User
import com.rightcode.huespine.domain.repository.AuthRepository
import com.rightcode.huespine.domain.repository.MessagingRepository
import com.rightcode.huespine.domain.repository.SessionRepository
import com.rightcode.huespine.domain.repository.UserRepository
import com.rightcode.huespine.domain.util.getOrNull
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class AuthServiceImpl @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
    private val sessionRepository: SessionRepository,
    private val messagingRepository: MessagingRepository
) : AuthService {

    override fun login(email: String, password: String): Completable {
        return authRepository.login(email, password)
            .flatMapCompletable { user ->
                Completable.mergeArray(
                    saveUser(user),
                    saveSession(user.id),
                    subscribeFirebase(user.id)
                )
            }
    }

    override fun register(
        type: String,
        email: String,
        name: String,
        password: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Completable {
        return authRepository.register(
            type,
            email,
            name,
            password,
            profileId,
            tasteIds,
            categoryIds
        ).flatMapCompletable { user ->
            Completable.mergeArray(
                saveUser(user),
                saveSession(user.id),
                subscribeFirebase(user.id)
            )
        }
    }

    private fun saveUser(user: User): Completable {
        return userRepository.save(user)
    }

    private fun saveSession(userId: Long): Completable {
        return sessionRepository.save(userId)
    }

    override fun checkEmailDuplicate(email: String): Completable {
        return authRepository.checkEmailDuplicated(email)
    }

    override fun checkNicknameDuplicate(name: String): Completable {
        return authRepository.checkNicknameDuplicated(name)
    }

    override fun checkAuth(): Completable = authRepository.checkAuth()

    override fun logout(): Completable {
        return userRepository.fetchUser()
            .firstOrError()
            .flatMapCompletable { user ->
                authRepository.logout()
                    .andThen(unsubscribeFirebase(user.getOrNull()?.id ?: 0L))
            }
    }

    private fun subscribeFirebase(userId: Long): Completable {
        return messagingRepository.subscribeToTopic(com.rightcode.huespine.domain.service.AuthServiceImpl.Companion.FORMAT_FCM_TOPIC_USER.format(userId))
    }

    private fun unsubscribeFirebase(userId: Long): Completable {
        return messagingRepository.unsubscribeFromTopic(com.rightcode.huespine.domain.service.AuthServiceImpl.Companion.FORMAT_FCM_TOPIC_USER.format(userId))
    }

    override fun passwordReset(email: String) = authRepository.passwordReset(email)

    override fun loginWithKakao(token: String): Completable {
        return authRepository.loginWithSocial("kakao", token)
            .flatMapCompletable { user ->
                Completable.mergeArray(
                    saveUser(user),
                    saveSession(user.id),
                    subscribeFirebase(user.id)
                )
            }
    }

    override fun loginWithApple(
        token: String
    ): Completable {
        return authRepository.loginWithSocial("apple", token)
            .flatMapCompletable { user ->
                Completable.mergeArray(
                    saveUser(user),
                    saveSession(user.id),
                    subscribeFirebase(user.id)
                )
            }
    }

    override fun loginWithGoogle(token: String): Completable {
        return authRepository.loginWithSocial("google", token)
            .flatMapCompletable { user ->
                Completable.mergeArray(
                    saveUser(user),
                    saveSession(user.id),
                    subscribeFirebase(user.id)
                )
            }
    }

    override fun registerWithSocial(
        type: String,
        token: String,
        name: String,
        profileId: Int,
        tasteIds: List<Int>,
        categoryIds: List<Int>
    ): Completable {
        return authRepository.registerWithSocial(
            type = type,
            socialToken = token,
            name = name,
            profileId = profileId,
            tasteIds = tasteIds,
            categoryIds = categoryIds
        ).flatMapCompletable { user ->
            Completable.mergeArray(
                saveUser(user),
                saveSession(user.id),
                subscribeFirebase(user.id)
            )
        }
    }

    override fun getTokenInfo(type: String, token: String): Single<String> {
        return authRepository.getTokenInfo(type, token)
    }

    companion object {
        private const val FORMAT_FCM_TOPIC_USER = "user_%d"
    }
}