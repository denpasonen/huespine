package com.rightcode.huespine.local.di

import com.rightcode.huespine.data.source.local.*
import com.rightcode.huespine.local.*
import com.rightcode.huespine.local.preferences.*
import com.rightcode.huespine.local.preferences.BannerPref
import com.rightcode.huespine.local.preferences.BannerPrefImpl
import com.rightcode.huespine.local.preferences.SearchPref
import com.rightcode.huespine.local.preferences.SessionPref
import com.rightcode.huespine.local.preferences.SessionPrefImpl
import com.rightcode.huespine.local.spectrum.SpectrumWrapper
import com.rightcode.huespine.local.spectrum.SpectrumWrapperImpl
import com.rightcode.huespine.local.utils.rx.schedulers.SchedulerProvider
import com.rightcode.huespine.local.utils.rx.schedulers.SchedulerProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface LocalDataModule {

    @Singleton
    @Binds
    fun bindSchedulerProvider(implement: SchedulerProviderImpl): SchedulerProvider

    @Singleton
    @Binds
    fun bindUserPref(pref: SessionPrefImpl): SessionPref

    @Singleton
    @Binds
    fun bindBannerPref(pref: BannerPrefImpl): BannerPref

    @Singleton
    @Binds
    fun bindSearchPref(pref: SearchPrefImpl): SearchPref

    @Singleton
    @Binds
    fun bindSpectrumProvider(implement: SpectrumWrapperImpl): SpectrumWrapper

    @Singleton
    @Binds
    fun bindSessionLocalDataSource(dataSource: SessionLocalDataSourceImpl): SessionLocalDataSource

    @Singleton
    @Binds
    fun bindAuthLocalDataSource(
        dataSource: AuthLocalDataSourceImpl
    ): AuthLocalDataSource

    @Singleton
    @Binds
    fun bindBannerLocalDataSource(
        dataSource: BannerLocalDataSourceImpl
    ): BannerLocalDataSource

    @Singleton
    @Binds
    fun bindUserLocalDataSource(
        dataSource: UserLocalDataSourceImpl
    ): UserLocalDataSource

    @Singleton
    @Binds
    fun bindFileLocalDataSource(
        dataSource: FileLocalDataSourceImpl
    ): FileLocalDataSource

    @Singleton
    @Binds
    fun bindNaverAuthLocalDataSource(
        dataSource: NaverAuthLocalDataSourceImpl
    ): NaverAuthLocalDataSource

    @Singleton
    @Binds
    fun bindSearchLocalDataSource(
        dataSource: SearchLocalDataSourceImpl
    ): SearchLocalDataSource
}