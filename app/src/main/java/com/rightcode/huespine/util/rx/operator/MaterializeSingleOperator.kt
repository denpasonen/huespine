package com.rightcode.huespine.util.rx.operator

import io.reactivex.Notification
import io.reactivex.SingleObserver
import io.reactivex.SingleOperator
import io.reactivex.disposables.Disposable

class MaterializeSingleOperator<T> : SingleOperator<Notification<T>, T> {
    override fun apply(observer: SingleObserver<in Notification<T>>): SingleObserver<in T> {
        return object : SingleObserver<T> {
            override fun onSuccess(t: T) {
                observer.onSuccess(Notification.createOnNext(t))
            }

            override fun onSubscribe(d: Disposable) {
                observer.onSubscribe(d)
            }

            override fun onError(e: Throwable) {
                observer.onSuccess(Notification.createOnError(e))
            }

        }
    }
}