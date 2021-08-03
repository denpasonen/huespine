package com.rightcode.huespine.util.transformations

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import java.util.*

class DeOptionalizeObservableTransformation<U> : ObservableTransformer<Optional<U>, U> {
    override fun apply(upstream: Observable<Optional<U>>): ObservableSource<U> {
        return upstream.map { optional -> optional.get() }
    }
}