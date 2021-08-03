package com.rightcode.huespine.remote.di

import android.app.Application
import com.rightcode.huespine.remote.BuildConfig
import com.rightcode.huespine.remote.retrofit.api.*
import com.rightcode.huespine.remote.retrofit.interceptor.ConnectionInterceptor
import com.rightcode.huespine.remote.retrofit.interceptor.KKAuthInterceptor
import com.rightcode.huespine.remote.utils.EnumConverterFactory
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class RemoteModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
        connectionInterceptor: ConnectionInterceptor,
        kkAuthInterceptor: KKAuthInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                if (BuildConfig.DEBUG) {
                    level = HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(connectionInterceptor)
            .addInterceptor(kkAuthInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(EnumConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @Singleton
    @Provides
    fun provideCategoriesApi(retrofit: Retrofit): CategoriesApi =
        retrofit.create(CategoriesApi::class.java)

    @Singleton
    @Provides
    fun provideProfileCharactersApi(retrofit: Retrofit): ProfileCharactersApi =
        retrofit.create(ProfileCharactersApi::class.java)

    @Singleton
    @Provides
    fun provideTastesApi(retrofit: Retrofit): TastesApi =
        retrofit.create(TastesApi::class.java)

    @Singleton
    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi =
        retrofit.create(HomeApi::class.java)

    @Singleton
    @Provides
    fun provideBannerApi(retrofit: Retrofit): BannerApi =
        retrofit.create(BannerApi::class.java)

    @Singleton
    @Provides
    fun provideProductApi(retrofit: Retrofit): ProductApi =
        retrofit.create(ProductApi::class.java)

    @Singleton
    @Provides
    fun provideMallApi(retrofit: Retrofit): MallApi =
        retrofit.create(MallApi::class.java)

    @Singleton
    @Provides
    fun provideHashtagApi(retrofit: Retrofit): HashtagApi =
        retrofit.create(HashtagApi::class.java)

    @Singleton
    @Provides
    fun provideMallTypeApi(retrofit: Retrofit): MallTypeApi =
        retrofit.create(MallTypeApi::class.java)

    @Singleton
    @Provides
    fun provideKeywordApi(retrofit: Retrofit): KeywordApi =
        retrofit.create(KeywordApi::class.java)

    @Singleton
    @Provides
    fun providePostApi(retrofit: Retrofit): PostApi =
        retrofit.create(PostApi::class.java)

    @Singleton
    @Provides
    fun provideUserProductApi(retrofit: Retrofit): UserProductApi =
        retrofit.create(UserProductApi::class.java)

    @Singleton
    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi =
        retrofit.create(UserApi::class.java)

    @Singleton
    @Provides
    fun provideFileApi(retrofit: Retrofit): FileApi =
        retrofit.create(FileApi::class.java)

    @Singleton
    @Provides
    fun provideUploadApi(retrofit: Retrofit): UploadApi =
        retrofit.create(UploadApi::class.java)

    @Singleton
    @Provides
    fun provideNotificationApi(retrofit: Retrofit): NotificationApi =
        retrofit.create(NotificationApi::class.java)

    @Singleton
    @Provides
    fun provideContactsApi(retrofit: Retrofit): ContactsApi =
        retrofit.create(ContactsApi::class.java)

    @Singleton
    @Provides
    fun provideUserSettingApi(retrofit: Retrofit): UserSettingApi =
        retrofit.create(UserSettingApi::class.java)

    @Singleton
    @Provides
    fun providesInAppUpdateManager(application: Application): AppUpdateManager =
        AppUpdateManagerFactory.create(application)

    @Singleton
    @Provides
    fun providesEventApi(retrofit: Retrofit): EventApi =
        retrofit.create(EventApi::class.java)

}