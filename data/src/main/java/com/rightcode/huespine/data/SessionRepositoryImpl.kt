package com.rightcode.huespine.data

import com.rightcode.huespine.data.source.local.SessionLocalDataSource
import com.rightcode.huespine.domain.repository.SessionRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

internal class SessionRepositoryImpl @Inject constructor(
    private val local: SessionLocalDataSource
) : SessionRepository {
    override val userId: Long?
        get() = local.userId

    override fun fetchUserId(): Flowable<Optional<Long>> {
        return local.fetchUserId()
    }

    override fun save(userId: Long): Completable {
        return Completable.fromCallable {
            local.saveUserId(userId)
        }
    }

    override fun clearAll(): Completable {
        return Completable.fromCallable {
            this.local.clearAll()
        }
    }
}