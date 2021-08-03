package com.rightcode.huespine.util.rx.ext

import com.rightcode.huespine.util.rx.transformer.*
import io.reactivex.Notification
import io.reactivex.Observable
import java.util.*
import kotlin.reflect.KClass

fun Observable<Boolean>.filter(): Observable<Boolean> {
    return this.filter { boolean -> boolean }
}


fun <S, T> Observable<S>.takeWhen(`when`: Observable<T>): Observable<S> {
    return this.compose(
        TakeWhenObservableTransformer<S, T>(
            `when`
        )
    )
}

fun <S, T> Observable<S>.takePairWhen(`when`: Observable<T>): Observable<Pair<S, T>> {
    return this.compose(
        TakePairWhenObservableTransformer(
            `when`
        )
    )
}

fun <T> Observable<Notification<T>>.values(): Observable<T> {
    return this.compose(ValueObservableTransformer())
}

fun <T> Observable<Notification<T>>.errors(): Observable<Throwable> {
    return this.compose(ErrorObservableTransformer())
}

fun <T : Any, U : Any> Observable<U>.filterInstance(typeClass: KClass<T>): Observable<T> {
    return this.compose(FilterInstanceObservableTransformer<T, U>(typeClass))
}

fun <T> Observable<Optional<T>>.ifPresent(): Observable<T> {
    return this.compose(IfPresentObservableTransformation())
}
