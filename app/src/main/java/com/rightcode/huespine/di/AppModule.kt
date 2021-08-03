package com.rightcode.huespine.di

import com.rightcode.huespine.domain.provider.SchedulerProvider
import com.rightcode.huespine.provider.ConnectionProviderImpl
import com.rightcode.huespine.remote.provider.ConnectionProvider
import com.rightcode.huespine.util.ResourceProvider
import com.rightcode.huespine.util.ResourceProviderImpl
import com.rightcode.huespine.util.rx.scheduler.SchedulerProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface AppModule {
    @Singleton
    @Binds
    fun bindSchedulerProvider(
        schedulerProvider: SchedulerProviderImpl
    ): SchedulerProvider

    @Singleton
    @Binds
    fun bindResourceProvider(
        resourceProvider: ResourceProviderImpl
    ): ResourceProvider

    @Singleton
    @Binds
    fun bindConnectionProvider(
        provider: ConnectionProviderImpl
    ): ConnectionProvider

    /*@Singleton
    @Binds
    fun bindFirebaseMessagingProvider(
        provider: FirebaseMessagingProviderImpl
    ): FirebaseMessagingProvider
    */
}