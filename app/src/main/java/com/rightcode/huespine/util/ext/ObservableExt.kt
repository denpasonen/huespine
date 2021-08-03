package com.rightcode.huespine.util.ext

import com.rightcode.huespine.util.transformations.DeOptionalizeObservableTransformation
import com.rightcode.huespine.util.transformations.IfPresentObservableTransformation
import com.rightcode.huespine.util.transformations.OptionalizeObservableTransformation
import io.reactivex.Observable
import java.util.*


fun <T> Observable<T>.optionalize(): Observable<Optional<T>> {
    return this.compose(OptionalizeObservableTransformation())
}

fun <T> Observable<Optional<T>>.deoptionalize(): Observable<T> {
    return this.compose(DeOptionalizeObservableTransformation())
}


fun <T> Observable<Optional<T>>.ifPresent(): Observable<T> {
    return this.compose(IfPresentObservableTransformation())
}
