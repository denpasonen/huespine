package com.rightcode.huespine.util.rx.transformer

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class TakeWhenObservableTransformer<S, T>(
    private val `when`: Observable<T>
) : ObservableTransformer<S, S> {
    override fun apply(upstream: Observable<S>): ObservableSource<S> {
        return `when`.withLatestFrom(upstream, { _, x -> x })
    }
}