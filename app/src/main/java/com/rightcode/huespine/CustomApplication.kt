package com.rightcode.huespine

import android.webkit.WebView
import com.rightcode.huespine.view.base.BaseApplication
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.plugins.RxJavaPlugins

@HiltAndroidApp
class CustomApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())

        RxJavaPlugins.setErrorHandler { error: Throwable ->
//            FirebaseCrashlytics.getInstance().recordException(error)
        }

        initUncaughtExceptionHandler()
        initWebView()
    }

    private fun initUncaughtExceptionHandler() {
/*        val defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { _, _ -> }
        Thread.setDefaultUncaughtExceptionHandler(
            HGExceptionHandler(
                this,
                FirebaseCrashlytics.getInstance(),
                defaultExceptionHandler
            )
        )*/
    }

    private fun initWebView() {
        WebView.setWebContentsDebuggingEnabled(BuildConfig.DEBUG)
    }


}