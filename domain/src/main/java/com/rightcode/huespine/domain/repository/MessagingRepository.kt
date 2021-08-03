package com.rightcode.huespine.domain.repository

import io.reactivex.Completable

interface MessagingRepository {
    fun subscribeToTopic(topic: String): Completable

    fun unsubscribeFromTopic(topic: String): Completable
}