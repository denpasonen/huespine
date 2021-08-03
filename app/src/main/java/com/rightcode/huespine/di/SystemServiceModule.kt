package com.rightcode.huespine.di

import android.app.NotificationManager
import android.content.Context
import android.net.ConnectivityManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class SystemServiceModule {
    @Singleton
    @Provides
    fun provideConnectivityManager(
        @ApplicationContext context: Context
    ) = context.getSystemService<ConnectivityManager>()!!

    @Singleton
    @Provides
    fun provideSoftKeyboardManager(
        @ApplicationContext context: Context
    ) = context.getSystemService<InputMethodManager>()!!

    @Singleton
    @Provides
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ) = context.getSystemService<NotificationManager>()!!
}