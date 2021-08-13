package com.rightcode.huespine.data.di

import com.rightcode.huespine.data.*
import com.rightcode.huespine.data.provider.SessionProvider
import com.rightcode.huespine.data.provider.SessionProviderImpl
import com.rightcode.huespine.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Singleton
    @Binds
    fun bindSessionProvider(provider: SessionProviderImpl): SessionProvider

    @Singleton
    @Binds
    fun bindAuthRepository(
        repository: AuthRepositoryImpl
    ): AuthRepository

    @Singleton
    @Binds
    fun bindSessionRepository(
        repository: SessionRepositoryImpl
    ): SessionRepository

    @Singleton
    @Binds
    fun bindUserRepository(
        repository: UserRepositoryImpl
    ): UserRepository

    @Singleton
    @Binds
    fun bindCategoriesRepository(
        repository: CategoriesRepositoryImpl
    ): CategoriesRepository

    @Singleton
    @Binds
    fun bindProfileCharactersRepository(
        repository: ProfileCharactersRepositoryImpl
    ): ProfileCharactersRepository

    @Singleton
    @Binds
    fun bindTastesRepository(
        repository: TastesRepositoryImpl
    ): TastesRepository

    @Singleton
    @Binds
    fun bindHomeRepository(
        repository: HomeRepositoryImpl
    ): HomeRepository

    @Singleton
    @Binds
    fun bindBannerRepository(
        repository: BannerRepositoryImpl
    ): BannerRepository

    @Singleton
    @Binds
    fun bindProductRepository(
        repository: ProductRepositoryImpl
    ): ProductRepository

    @Singleton
    @Binds
    fun bindPostRepository(
        repository: PostRepositoryImpl
    ): PostRepository

    @Singleton
    @Binds
    fun bindUserProductRepository(
        repository: UserProductRepositoryImpl
    ): UserProductRepository

    @Singleton
    @Binds
    fun bindMallRepository(
        repository: MallRepositoryImpl
    ): MallRepository

    @Singleton
    @Binds
    fun bindHashtagRepository(
        repository: HashtagRepositoryImpl
    ): HashtagRepository

    @Singleton
    @Binds
    fun bindMallTypeRepository(
        repository: MallTypeRepositoryImpl
    ): MallTypeRepository

    @Singleton
    @Binds
    fun bindKeywordRepository(
        repository: KeywordRepositoryImpl
    ): KeywordRepository

    @Singleton
    @Binds
    fun bindFileRepository(
        repository: FileRepositoryImpl
    ): FileRepository

    @Singleton
    @Binds
    fun bindNotificationRepository(
        repository: NotificationRepositoryImpl
    ): NotificationRepository

    @Singleton
    @Binds
    fun bindVersionRepository(
        repository: VersionRepositoryImpl
    ): VersionRepository

    @Singleton
    @Binds
    fun bindContactsRepository(
        repository: ContactsRepositoryImpl
    ): ContactsRepository

    @Singleton
    @Binds
    fun bindUserSettingRepository(
        repository: UserSettingRepositoryImpl
    ): UserSettingRepository

    @Singleton
    @Binds
    fun bindEventRepository(
        repository: EventRepositoryImpl
    ): EventRepository

    @Singleton
    @Binds
    fun bindMessagingRepository(
        repository: MessagingRepositoryImpl
    ): MessagingRepository
}