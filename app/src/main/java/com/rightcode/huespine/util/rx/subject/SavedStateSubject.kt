package com.rightcode.huespine.util.rx.subject

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.SavedStateHandle
import com.rightcode.huespine.util.ext.getOrNull
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.Subject
import java.lang.ref.WeakReference
import java.util.*

class SavedStateSubject<T>(
    stateHandle: SavedStateHandle,
    private val key: String,
    private val actual: Subject<T>
) : Subject<T>() {
    private var stateHandleRef = WeakReference(stateHandle)
    private val handler = Handler(Looper.getMainLooper())

    override fun hasThrowable(): Boolean {
        return actual.hasThrowable()
    }

    override fun hasObservers(): Boolean {
        return actual.hasObservers()
    }

    override fun onComplete() {
        actual.onComplete()
    }

    override fun onSubscribe(d: Disposable) {
        actual.onSubscribe(d)
    }

    override fun onError(e: Throwable) {
        actual.onError(e)
    }

    override fun getThrowable(): Throwable? {
        return actual.throwable
    }

    override fun subscribeActual(observer: Observer<in T>) {
        actual.subscribe(observer)
    }

    override fun onNext(t: T) {
        handler.post {
            if (t is Optional<*>) {
                stateHandleRef.get()?.set(key, t.getOrNull())
            } else {
                stateHandleRef.get()?.set(key, t)
            }
        }
        actual.onNext(t)
    }

    override fun hasComplete(): Boolean {
        return actual.hasComplete()
    }

}