package com.rightcode.huespine.util.rx.transformer

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import java.util.*

class IfPresentObservableTransformation<U> : ObservableTransformer<Optional<U>, U> {
    override fun apply(upstream: Observable<Optional<U>>): ObservableSource<U> {
        return upstream.filter(Optional<U>::isPresent)
            .map(Optional<U>::get)
    }
}