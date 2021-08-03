package com.rightcode.huespine.util.rx.transformer

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import kotlin.reflect.KClass

class FilterInstanceObservableTransformer<T : Any, U : Any>(
    private val typeClass: KClass<T>
) : ObservableTransformer<U, T> {
    @Suppress("UNCHECKED_CAST")
    override fun apply(upstream: Observable<U>): ObservableSource<T> {
        return upstream.filter(typeClass::isInstance)
            .map { target -> target as T }
    }
}