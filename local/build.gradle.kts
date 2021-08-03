import com.rightcode.huespine.buildsrc.getOrCreate

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getOrCreate("debug") {
            aaptOptions.cruncherEnabled = false

            isDebuggable = true
            isMinifyEnabled = false

            consumerProguardFiles("consumer-rules.pro")
        }
        getOrCreate("release") {
            consumerProguardFiles("consumer-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":data"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
    implementation("androidx.core:core-ktx:1.6.0")

    implementation("androidx.startup:startup-runtime:1.1.0-beta01")

    implementation("io.reactivex.rxjava2:rxjava:2.2.19")
    implementation("com.google.dagger:hilt-android:2.36")
    kapt("com.google.dagger:hilt-compiler:2.36")

    api("androidx.room:room-runtime:2.3.0")
    implementation("androidx.room:room-rxjava2:2.3.0")
    kapt("androidx.room:room-compiler:2.3.0")
    testImplementation("androidx.room:room-testing:2.3.0")

    api("com.facebook.spectrum:spectrum-core:1.2.0")
    implementation("com.facebook.spectrum:spectrum-jpeg:1.2.0")
    implementation("com.facebook.spectrum:spectrum-png:1.2.0")
    implementation("com.facebook.spectrum:spectrum-webp:1.2.0")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation("com.naver.nid:naveridlogin-android-sdk:4.2.6") {
        exclude("com.android.support", "appcompat-v7")
        exclude("com.android.support", "support-core-utils")
        exclude("com.android.support", "customtabs")
        exclude("com.android.support", "support-v4")
    }

}