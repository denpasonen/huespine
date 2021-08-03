package com.rightcode.huespine.local.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject

internal class BannerPrefImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : BannerPref {
    override var notShowToday: String?
        get() = sharedPreferences.getString(KEY_BANNER_DATE, "")
        set(value) {
            sharedPreferences.edit {
                if (value == null) {
                    remove(KEY_BANNER_DATE)
                } else {
                    putString(KEY_BANNER_DATE, value)
                }
            }
        }

    override fun getNoeShowDate(): Flowable<Optional<String>> {
        return Flowable.create({ emitter ->
            val listener =
                SharedPreferences.OnSharedPreferenceChangeListener { sharedPref, key ->
                    if (!emitter.isCancelled && key == KEY_BANNER_DATE) {
                        emitter.onNext(sharedPref.getString(KEY_BANNER_DATE, "").let {
                            if (it == "") Optional.empty() else Optional.of(it!!)
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
        private const val KEY_BANNER_DATE = "keyBannerDate"
    }
}