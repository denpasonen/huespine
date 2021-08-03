package com.rightcode.huespine.buildsrc

object App {
    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 30
    const val versionCode = 21080212
    const val versionName = "1.0.0"

    const val navigationFragment: String =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUi: String =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    const val navigationDynamic: String =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigationVersion}"
}

object Remote {

    const val retrofit: String = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverter: String =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    const val retrofitAdapter: String =
        "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    const val okHttp: String = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val loggingInterceptor: String =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"

    const val stetho: String = "com.facebook.stetho:stetho:${Versions.stethoVersion}"
    const val stethoOkHttp: String = "com.facebook.stetho:stetho-okhttp3:${Versions.stethoVersion}"
}

object Rx {
    const val rxJava: String = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val rxAndroid: String = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val rxKotlin: String = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlinVersion}"
}

object DI {
    const val daggerHiltAndroid: String =
        "com.google.dagger:hilt-android:${Versions.daggerHiltAndroidVersion}"
    const val hiltTesting: String =
        "com.google.dagger:hilt-android-testing:${Versions.daggerHiltAndroidVersion}"
}

object Core {
    const val coreKtx: String = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val stdLib: String = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
}

object Versions {
    const val kotlinVersion = "1.4.30"
    const val retrofitVersion = "2.9.0"
    const val okHttpVersion = "4.8.0"
    const val stethoVersion = "1.5.1"
    const val coreKtxVersion = "1.3.0"
    const val rxJavaVersion = "2.2.19"
    const val rxKotlinVersion = "2.4.0"
    const val rxAndroidVersion = "2.1.1"
    const val navigationVersion = "2.3.1"

    const val daggerHiltAndroidVersion = "2.29.1-alpha"

}