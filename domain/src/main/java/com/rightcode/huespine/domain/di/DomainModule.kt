package com.rightcode.huespine.domain.di

import com.rightcode.huespine.domain.service.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DomainModule {
    @Singleton
    @Binds
    fun bindAuthService(
        service: AuthServiceImpl
    ): AuthService

    @Singleton
    @Binds
    fun bindUserService(
        service: UsersServiceImpl
    ): UserService

    @Singleton
    @Binds
    fun bindCategoriesService(
        service: CategoriesServiceImpl
    ): CategoriesService

    @Singleton
    @Binds
    fun bindProfileCharactersService(
        service: ProfileCharactersServiceImpl
    ): ProfileCharactersService

    @Singleton
    @Binds
    fun bindTastesService(
        service: TastesServiceImpl
    ): TastesService

    @Singleton
    @Binds
    fun bindHomeService(
        service: HomeServiceImpl
    ): HomeService

    @Singleton
    @Binds
    fun bindBannerService(
        service: BannerServiceImpl
    ): BannerService

    @Singleton
    @Binds
    fun bindSessionService(
        service: SessionServiceImpl
    ): SessionService

    @Singleton
    @Binds
    fun bindProductService(
        service: ProductServiceImpl
    ): ProductService

    @Singleton
    @Binds
    fun bindMallService(
        service: MallServiceImpl
    ): MallService

    @Singleton
    @Binds
    fun bindHashtagService(
        service: HashtagServiceImpl
    ): HashtagService

    @Singleton
    @Binds
    fun bindMallTypeService(
        service: MallTypeServiceImpl
    ): MallTypeService


    @Singleton
    @Binds
    fun bindKeywordService(
        service: KeywordServiceImpl
    ): KeywordService

    @Singleton
    @Binds
    fun bindPostService(
        service: PostServiceImpl
    ): PostService

    @Singleton
    @Binds
    fun bindUserProductService(
        service: UserProductServiceImpl
    ): UserProductService

    @Singleton
    @Binds
    fun bindNotificationService(
        service: NotificationServiceImpl
    ): NotificationService

    @Singleton
    @Binds
    fun bindVersionService(
        repository: VersionServiceImpl
    ): VersionService

    @Singleton
    @Binds
    fun bindContactsService(
        repository: ContactsServiceImpl
    ): ContactsService

    @Singleton
    @Binds
    fun bindUserSettingService(
        repository: UserSettingServiceImpl
    ): UserSettingService

    @Singleton
    @Binds
    fun bindEventService(
        repository: EventServiceImpl
    ): EventService
}