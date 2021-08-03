package com.rightcode.huespine.util.rx.transformer

import io.reactivex.Notification
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class ValueObservableTransformer<T> : ObservableTransformer<Notification<T>, T> {
    override fun apply(upstream: Observable<Notification<T>>): ObservableSource<T> {
        return upstream.filter(Notification<T>::isOnNext)
            .map(Notification<T>::getValue)
    }
}