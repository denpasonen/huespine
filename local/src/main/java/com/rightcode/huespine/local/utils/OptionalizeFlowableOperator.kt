package com.rightcode.huespine.local.utils

import io.reactivex.FlowableOperator
import io.reactivex.FlowableSubscriber
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.util.*

internal class OptionalizeFlowableOperator<T> : FlowableOperator<Optional<T>, T> {
    override fun apply(subscriber: Subscriber<in Optional<T>>): Subscriber<in T> {
        return object : FlowableSubscriber<T> {
            override fun onComplete() {
                subscriber.onComplete()
            }

            override fun onSubscribe(s: Subscription) {
                subscriber.onSubscribe(s)
            }

            override fun onNext(t: T) {
                subscriber.onNext(Optional.of(t))
            }

            override fun onError(t: Throwable?) {
                subscriber.onError(t)
            }

        }
    }

}