package com.rightcode.huespine.domain.service

import com.rightcode.huespine.domain.provider.SchedulerProvider
import com.rightcode.huespine.domain.repository.SessionRepository
import com.rightcode.huespine.domain.util.getOrNull
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject

class SessionServiceImpl @Inject constructor(
    private val sessionRepository: SessionRepository,
    private val schedulerProvider: SchedulerProvider,
) : SessionService {

    override fun isAuthenticatedChanged(): Flowable<Boolean> {
        return sessionRepository.fetchUserId()
            .observeOn(schedulerProvider.io)
            .map { it.isPresent && it.getOrNull() != 0L }
    }

    override fun logout(): Completable {
        return sessionRepository.clearAll()
    }
}