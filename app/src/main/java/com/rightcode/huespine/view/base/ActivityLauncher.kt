package com.rightcode.huespine.view.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import kotlin.reflect.KClass

abstract class ActivityLauncher<T : Activity> {
    protected abstract val activityClass: KClass<T>

    fun getIntent(context: Context): Intent {
        return Intent(context, activityClass.java)
    }

    open fun startActivity(context: Context) {
        context.startActivity(getIntent(context))
    }

    fun startActivityWithClear(context: Context) {
        context.startActivity(getIntent(context).apply {
            flags = flags or Intent.FLAG_ACTIVITY_CLEAR_TOP
        })
    }

    fun startActivityWithClearTask(context: Context) {
        context.startActivity(getIntent(context).apply {
            flags = flags or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        })
    }
}