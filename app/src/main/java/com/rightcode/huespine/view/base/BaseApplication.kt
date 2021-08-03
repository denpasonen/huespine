package com.rightcode.huespine.view.base

import android.app.Activity
import android.app.Application
import android.os.Bundle

abstract class BaseApplication : Application(), Application.ActivityLifecycleCallbacks {
    protected var lastActivity: Activity? = null
    protected var activityCount: Int = 0

    override fun onCreate() {
        super.onCreate()
        this.registerActivityLifecycleCallbacks(this)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        this.lastActivity = activity
        if (activityCount == 0) {
            this.onActivityAvailable()
        }
    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStarted(activity: Activity) {
        this.lastActivity = activity
        this.activityCount++
    }

    override fun onActivityDestroyed(activity: Activity) {
        if (activity == this.lastActivity) {
            this.lastActivity = null
            this.onActivityUnAvailable()
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityStopped(activity: Activity) {
        this.activityCount--
        if (activityCount == 0) {
            this.lastActivity = null
            this.onActivityUnAvailable()
        }
    }

    override fun onActivityResumed(activity: Activity) {

    }

    protected open fun onActivityAvailable() {

    }

    protected open fun onActivityUnAvailable() {

    }
}