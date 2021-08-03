package com.rightcode.huespine.local.utils.ext

import android.content.SharedPreferences
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

fun SharedPreferences.getFlowableLong(
    targetKey: String,
    defaultValue: Long
): Flowable<Long> {
    return Flowable.create({ emitter ->
        val listener =
            SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
                if (!emitter.isCancelled && key == targetKey) {
                    emitter.onNext(getLong(key, defaultValue))
                }
            }
        this.registerOnSharedPreferenceChangeListener(listener)
        emitter.setCancellable {
            this.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }, BackpressureStrategy.LATEST)
}

fun SharedPreferences.getFlowableString(
    targetKey: String,
    defaultValue: String
): Flowable<String> {
    return Flowable.create({ emitter ->
        val listener =
            SharedPreferences.OnSharedPreferenceChangeListener { sharedPref, key ->
                if (!emitter.isCancelled && key == targetKey) {
                    emitter.onNext(sharedPref.getString(targetKey, defaultValue) ?: defaultValue)
                }
            }
        this.registerOnSharedPreferenceChangeListener(listener)
        emitter.setCancellable {
            this.unregisterOnSharedPreferenceChangeListener(listener)
        }
        emitter.onNext(this.getString(targetKey, defaultValue) ?: defaultValue)
    }, BackpressureStrategy.LATEST)
}

