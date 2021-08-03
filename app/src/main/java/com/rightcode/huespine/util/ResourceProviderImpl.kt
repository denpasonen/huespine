package com.rightcode.huespine.util

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ResourceProviderImpl @Inject constructor(
    @ApplicationContext
    context: Context
) : ResourceProvider {
    private val applicationContext: Context = context.applicationContext

    override fun getDrawable(resId: Int): Drawable {
        return ContextCompat.getDrawable(applicationContext, resId)!!
    }

    override fun getStringArray(resId: Int): Array<String> {
        return applicationContext.resources.getStringArray(resId)
    }

    override fun getColor(resId: Int): Int {
        return ContextCompat.getColor(applicationContext, resId)
    }

    override fun getString(resId: Int): String {
        return applicationContext.getString(resId)
    }
}