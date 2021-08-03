package com.rightcode.huespine.util.lifecycle

import androidx.lifecycle.SavedStateHandle
import com.rightcode.huespine.util.rx.subject.SavedStateSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import java.util.*

fun <T> SavedStateHandle.getSubject(key: String, defaultValue: T? = null): Subject<T> {
    val value = get<T>(key)
    return when {
        value != null -> {
            SavedStateSubject(this, key, BehaviorSubject.createDefault(value))
        }
        defaultValue != null -> {
            SavedStateSubject(this, key, BehaviorSubject.createDefault(defaultValue))
        }
        else -> {
            SavedStateSubject(this, key, BehaviorSubject.create())
        }
    }
}

fun <T> SavedStateHandle.getOptionalSubject(
    key: String,
    defaultValue: T? = null
): Subject<Optional<T>> {
    val value = get<T>(key)
    return when {
        value != null -> {
            SavedStateSubject(this, key, BehaviorSubject.createDefault(Optional.of(value)))
        }
        defaultValue != null -> {
            SavedStateSubject(this, key, BehaviorSubject.createDefault(Optional.of(defaultValue)))
        }
        else -> {
            SavedStateSubject(this, key, BehaviorSubject.createDefault(Optional.empty()))
        }
    }
}
