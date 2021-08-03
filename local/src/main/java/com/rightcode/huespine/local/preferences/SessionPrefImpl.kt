package com.rightcode.huespine.local.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import java.util.*
import javax.inject.Inject

internal class SessionPrefImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : SessionPref {
    override var currentUserId: Long?
        get() = sharedPreferences.getLong(KEY_CURRENT_USER_ID, 0L)
        set(value) {
            sharedPreferences.edit {
                if (value == null) {
                    remove(KEY_CURRENT_USER_ID)
                } else {
                    putLong(KEY_CURRENT_USER_ID, value)
                }
            }
        }

    override var cookieSid: String?
        get() = sharedPreferences.getString(KEY_ACCESS_TOKEN, null)
        set(value) {
            sharedPreferences.edit {
                if (value == null) {
                    remove(KEY_ACCESS_TOKEN)
                } else {
                    putString(KEY_ACCESS_TOKEN, value)
                }
            }
        }

    override fun fetchUserId(): Flowable<Optional<Long>> {
        return Flowable.create({ emitter ->
            val listener =
                SharedPreferences.OnSharedPreferenceChangeListener { sharedPref, key ->
                    if (!emitter.isCancelled && key == KEY_CURRENT_USER_ID) {
                        emitter.onNext(sharedPref.getLong(KEY_CURRENT_USER_ID, -1L).let {
                            if (it == -1L) Optional.empty() else Optional.of(it)
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
        private const val KEY_ACCESS_TOKEN = "keyAccessToken"
        private const val KEY_CURRENT_USER_ID = "keyCurrentUserId"
    }
}