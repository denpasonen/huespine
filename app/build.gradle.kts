import com.rightcode.huespine.buildsrc.getOrCreate

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
//    id("com.google.gms.google-services")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.3")

    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getOrCreate("KeyStore_Release") {
            keyAlias = "gazetfactory"
            keyPassword = "kkooit1024"
            storeFile = file("../Keystore")
            storePassword = "kkooit1024"
        }
    }

    flavorDimensions("type")
    productFlavors {
        getOrCreate("dev") {
            dimension = "type"
            applicationIdSuffix = ".dev"
        }
        getOrCreate("prod") {
            dimension = "type"
        }
    }

    buildTypes {
        getOrCreate("debug") {
            signingConfig = signingConfigs.getByName("debug")

            aaptOptions.cruncherEnabled = false
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            isZipAlignEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
//        getOrCreate("release") {
//            signingConfig = signingConfigs.getByName("Keystore/KeyStore_Release")
//
//            isMinifyEnabled = true
//            isShrinkResources = true
//            isZipAlignEnabled = true
//
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":remote"))
    implementation(project(":local"))

    implementation(com.rightcode.huespine.buildsrc.App.navigationFragment)
    implementation(com.rightcode.huespine.buildsrc.App.navigationUi)
    implementation(com.rightcode.huespine.buildsrc.App.navigationDynamic)

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.fragment:fragment-ktx:1.3.5")
    implementation("androidx.activity:activity:1.2.3")
    implementation("androidx.appcompat:appcompat:1.3.0")

    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("com.google.android.gms:play-services-auth:19.2.0")
//    implementation("com.google.android.play:core-ktx:1.8.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    implementation("io.coil-kt:coil:1.1.1")

    implementation("io.reactivex.rxjava2:rxjava:2.2.19")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("com.github.akarnokd:rxjava2-extensions:0.20.10")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.3.1")

    implementation("com.google.dagger:hilt-android:2.36")
    kapt("com.google.dagger:hilt-compiler:2.36")

    androidTestImplementation("com.google.dagger:hilt-android-testing:2.36")
    kaptAndroidTest("com.google.dagger:hilt-compiler:2.36")
    testImplementation("com.google.dagger:hilt-android-testing:2.36")
    kaptTest("com.google.dagger:hilt-compiler:2.36")

    implementation(platform("com.google.firebase:firebase-bom:28.2.0"))
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")

    implementation("com.orhanobut:logger:2.2.0")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.6")
    testImplementation("org.mockito:mockito-core:3.3.3")
    testImplementation("org.mockito:mockito-inline:2.13.0")

    debugImplementation("com.amitshekhar.android:debug-db:1.0.6")
    implementation("com.facebook.stetho:stetho:1.5.1")
    implementation("com.facebook.stetho:stetho-okhttp3:1.5.1")

    implementation("com.github.kizitonwose:CalendarView:0.3.5")
//    implementation("com.kakao.sdk:v2-link:2.5.2") // 메시지(카카오링크)
    implementation("gun0912.ted:tedpermission:2.2.3")
    implementation("com.google.android:flexbox:2.0.1")

//    implementation("com.naver.nid:naveridlogin-android-sdk:4.2.6")
//    implementation("com.kakao.sdk:v2-user:2.5.2")


}

kapt {
    correctErrorTypes = true
}
