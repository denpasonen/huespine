package com.rightcode.huespine.util.transformations

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import java.util.*

class OptionalizeObservableTransformation<U> : ObservableTransformer<U, Optional<U>> {
    override fun apply(upstream: Observable<U>): ObservableSource<Optional<U>> {
        return upstream.map { value ->
            Optional.of(value)
        }
    }
}