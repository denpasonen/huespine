package com.rightcode.huespine.util.rx.transformer

import io.reactivex.Notification
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class ErrorObservableTransformer : ObservableTransformer<Notification<*>, Throwable> {
    override fun apply(upstream: Observable<Notification<*>>): ObservableSource<Throwable> {
        return upstream.filter(Notification<*>::isOnError)
            .map(Notification<*>::getError)
    }
}