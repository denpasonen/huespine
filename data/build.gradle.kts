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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":domain"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
    implementation("androidx.core:core-ktx:1.6.0")

    implementation("io.reactivex.rxjava2:rxjava:2.2.19")
    implementation("com.google.dagger:hilt-android:2.36")
    kapt("com.google.dagger:hilt-compiler:2.36")

}