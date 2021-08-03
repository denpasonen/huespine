package com.rightcode.huespine.remote.provider

import io.reactivex.Completable

interface FirebaseMessagingProvider {
    fun subscribeToTopic(topic: String): Completable

    fun unsubscribeFromTopic(topic: String): Completable
}