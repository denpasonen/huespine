package com.rightcode.huespine.remote

import com.rightcode.huespine.data.source.remote.MessagingRemoteDataSource
import com.rightcode.huespine.remote.provider.FirebaseMessagingProvider
import io.reactivex.Completable
import javax.inject.Inject

internal class MessagingRemoteDataSourceImpl @Inject constructor(
    private val messagingProvider: FirebaseMessagingProvider
) : MessagingRemoteDataSource {
    override fun subscribeToTopic(topic: String): Completable {
        return messagingProvider.subscribeToTopic(topic)
    }

    override fun unsubscribeFromTopic(topic: String): Completable {
        return messagingProvider.unsubscribeFromTopic(topic)
    }
}