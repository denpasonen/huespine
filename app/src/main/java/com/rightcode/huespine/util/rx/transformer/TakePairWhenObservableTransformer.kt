package com.rightcode.huespine.util.rx.transformer

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class TakePairWhenObservableTransformer<S, T>(
    private val `when`: Observable<T>
) : ObservableTransformer<S, Pair<S, T>> {
    override fun apply(upstream: Observable<S>): ObservableSource<Pair<S, T>> {
        return `when`.withLatestFrom(upstream, { y, x -> x to y })
    }
}