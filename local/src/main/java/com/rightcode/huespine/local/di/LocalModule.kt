package com.rightcode.huespine.local.di

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.facebook.spectrum.Spectrum
import com.facebook.spectrum.logging.SpectrumLogcatLogger
import com.facebook.spectrum.plugins.SpectrumPluginJpeg
import com.facebook.spectrum.plugins.SpectrumPluginPng
import com.facebook.spectrum.plugins.SpectrumPluginWebp
import com.rightcode.huespine.local.BuildConfig
import com.rightcode.huespine.local.preferences.SharedPreferencesFactory
import com.rightcode.huespine.local.room.dao.UserDao
import com.rightcode.huespine.local.room.RightCodeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class LocalModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
        SharedPreferencesFactory.create(context)

    @Singleton
    @Provides
    fun provideDatabase(context: Context): RightCodeDatabase = RightCodeDatabase.create(context)

    @Singleton
    @Provides
    fun provideUserDao(database: RightCodeDatabase): UserDao = database.userDao

    @Singleton
    @Provides
    fun provideSpectrum(): Spectrum {
        return Spectrum.make(
            SpectrumLogcatLogger(
                if (BuildConfig.DEBUG) Log.DEBUG
                else Log.INFO
            ), arrayOf(
                SpectrumPluginJpeg.get(),
                SpectrumPluginPng.get(),
                SpectrumPluginWebp.get()
            )
        )
    }

    @Singleton
    @Provides
    fun provideContentResolver(
        context: Context
    ): ContentResolver {
        return context.contentResolver
    }
}