package com.rightcode.huespine.util.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData


inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline observer: (T?) -> Unit) {
    this.observe(owner, androidx.lifecycle.Observer { observer(it) })
}

inline fun <T> LiveData<T>.observeNotNull(
    owner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    this.observe(owner, androidx.lifecycle.Observer { observer(it!!) })
}
