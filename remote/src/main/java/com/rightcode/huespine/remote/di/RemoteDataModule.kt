package com.rightcode.huespine.remote.di

import com.rightcode.huespine.data.source.remote.*
import com.rightcode.huespine.remote.*
import com.rightcode.huespine.remote.utils.rx.schedulers.SchedulerProvider
import com.rightcode.huespine.remote.utils.rx.schedulers.SchedulerProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RemoteDataModule {

    @Singleton
    @Binds
    fun bindSchedulerProvider(implement: SchedulerProviderImpl): SchedulerProvider

    @Singleton
    @Binds
    fun bindAuthRemoteDataSource(
        dataSource: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource

    @Singleton
    @Binds
    fun bindUserRemoteDataSource(
        dataSource: UsersRemoteDataSourceImpl
    ): UserRemoteDataSource

    @Singleton
    @Binds
    fun bindTastesRemoteDataSource(
        dataSource: TastesRemoteDataSourceImpl
    ): TastesRemoteDataSource

    @Singleton
    @Binds
    fun bindProfileCharactersRemoteDataSource(
        dataSource: ProfileCharactersRemoteDataSourceImpl
    ): ProfileCharactersRemoteDataSource

    @Singleton
    @Binds
    fun bindCategoriesRemoteDataSource(
        dataSource: CategoriesRemoteDataSourceImpl
    ): CategoriesRemoteDataSource

    @Singleton
    @Binds
    fun bindHomeRemoteDataSource(
        dataSource: HomeRemoteDataSourceImpl
    ): HomeRemoteDataSource

    @Singleton
    @Binds
    fun bindBannerRemoteDataSource(
        dataSource: BannerRemoteDataSourceImpl
    ): BannerRemoteDataSource

    @Singleton
    @Binds
    fun bindProductRemoteDataSource(
        dataSource: ProductRemoteDataSourceImpl
    ): ProductRemoteDataSource

    @Singleton
    @Binds
    fun bindMallRemoteDataSource(
        dataSource: MallRemoteDataSourceImpl
    ): MallRemoteDataSource

    @Singleton
    @Binds
    fun bindHashtagRemoteDataSource(
        dataSource: HashtagRemoteDataSourceImpl
    ): HashtagRemoteDataSource

    @Singleton
    @Binds
    fun bindMallTypeRemoteDataSource(
        dataSource: MallTypeRemoteDataSourceImpl
    ): MallTypeRemoteDataSource

    @Singleton
    @Binds
    fun bindKeywordRemoteDataSource(
        dataSource: KeywordRemoteDataSourceImpl
    ): KeywordRemoteDataSource

    @Singleton
    @Binds
    fun bindPostRemoteDataSource(
        dataSource: PostRemoteDataSourceImpl
    ): PostRemoteDataSource

    @Singleton
    @Binds
    fun bindUserProductRemoteDataSource(
        dataSource: UserProductRemoteDataSourceImpl
    ): UserProductRemoteDataSource

    @Singleton
    @Binds
    fun bindFileRemoteDataSource(
        dataSource: FileRemoteDataSourceImpl
    ): FileRemoteDataSource

    @Singleton
    @Binds
    fun bindNotificationRemoteDataSource(
        dataSource: NotificationRemoteDataSourceImpl
    ): NotificationRemoteDataSource


    @Singleton
    @Binds
    fun bindVersionRemoteDataSource(
        dataSource: VersionRemoteDataSourceImpl
    ): VersionRemoteDataSource

    @Singleton
    @Binds
    fun bindContactsRemoteDataSource(
        dataSource: ContactsRemoteDataSourceImpl
    ): ContactsRemoteDataSource

    @Singleton
    @Binds
    fun UserSettingRemoteDataSource(
        dataSource: UserSettingRemoteDataSourceImpl
    ): UserSettingRemoteDataSource

    @Singleton
    @Binds
    fun EventRemoteDataSource(
        dataSource: EventRemoteDataSourceImpl
    ): EventRemoteDataSource

    @Singleton
    @Binds
    fun MessagingRemoteDataSource(
        dataSource: MessagingRemoteDataSourceImpl
    ): MessagingRemoteDataSource
}