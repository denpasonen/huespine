package com.rightcode.huespine.local.spectrum

import android.content.Context
import androidx.startup.Initializer
import com.facebook.spectrum.SpectrumSoLoader

class SpectrumContentProvider : Initializer<Unit> {
    override fun create(context: Context) {
        SpectrumSoLoader.init(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}