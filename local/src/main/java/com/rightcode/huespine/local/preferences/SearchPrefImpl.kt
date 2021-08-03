package com.rightcode.huespine.local.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

internal class SearchPrefImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SearchPref {
    override var searchList: Set<String>?
        get() = sharedPreferences.getStringSet(KEY_SEARCH, setOf())
        set(value) {
            sharedPreferences.edit {
                if (value == null) {
                    remove(KEY_SEARCH)
                } else {
                    putStringSet(KEY_SEARCH, value)
                }
            }}

    override fun getSearchList(): Flowable<Optional<Set<String>>> {
        return Flowable.create({ emitter ->
            val listener =
                SharedPreferences.OnSharedPreferenceChangeListener { sharedPref, key ->
                    if (!emitter.isCancelled && key == KEY_SEARCH) {
                        emitter.onNext(sharedPref.getStringSet(KEY_SEARCH, setOf()).let {
                            if (it.isNullOrEmpty()) Optional.empty() else Optional.of(it!!)
                        })
                    }
                }
            sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
            emitter.setCancellable {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
            }
        }, BackpressureStrategy.LATEST)
    }

    companion object {
        private const val KEY_SEARCH = "keySearch"
    }
}