package com.rightcode.huespine.provider

import com.rightcode.huespine.remote.provider.FirebaseMessagingProvider
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import io.reactivex.Completable
import javax.inject.Inject

class FirebaseMessagingProviderImpl @Inject constructor() : FirebaseMessagingProvider {
    override fun subscribeToTopic(topic: String): Completable {
        return Completable.create { emitter ->
            Firebase.messaging.subscribeToTopic(topic)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        emitter.onError(task.exception!!)
                    } else if (!task.isCanceled) {
                        emitter.onComplete()
                    }
                }
        }
    }

    override fun unsubscribeFromTopic(topic: String): Completable {
        return Completable.create { emitter ->
            Firebase.messaging.unsubscribeFromTopic(topic)
                .addOnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        emitter.onError(task.exception!!)
                    } else if (!task.isCanceled) {
                        emitter.onComplete()
                    }
                }
        }
    }
}