package com.rightcode.huespine.data

import com.rightcode.huespine.data.source.remote.MessagingRemoteDataSource
import com.rightcode.huespine.domain.repository.MessagingRepository
import io.reactivex.Completable
import javax.inject.Inject

internal class MessagingRepositoryImpl @Inject constructor(
    private val remote: MessagingRemoteDataSource
) : MessagingRepository {
    override fun subscribeToTopic(topic: String): Completable {
        return remote.subscribeToTopic(topic)
    }

    override fun unsubscribeFromTopic(topic: String): Completable {
        return remote.unsubscribeFromTopic(topic)
    }
}
