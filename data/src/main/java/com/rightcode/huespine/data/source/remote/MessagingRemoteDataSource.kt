package com.rightcode.huespine.data.source.remote

import io.reactivex.Completable

interface MessagingRemoteDataSource {
    fun subscribeToTopic(topic: String): Completable

    fun unsubscribeFromTopic(topic: String): Completable
}