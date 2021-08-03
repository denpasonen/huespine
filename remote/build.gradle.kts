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

    flavorDimensions("type")
    productFlavors {
        getOrCreate("dev") {
            dimension("type")

            buildConfigField("String", "BASE_URL", "\"https://dev-api.kkooit.net/users/\"")
        }

        getOrCreate("prod") {
            dimension("type")

            buildConfigField("String", "BASE_URL", "\"https://api.kkooit.net/users/\"")
        }
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
    implementation(project(":data"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.10")
    implementation("androidx.core:core-ktx:1.6.0")

    implementation("io.reactivex.rxjava2:rxjava:2.2.19")
    implementation("com.google.dagger:hilt-android:2.36")
    kapt("com.google.dagger:hilt-compiler:2.36")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-gson:2.9.0")
    api("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.8.0")
    api("com.squareup.okhttp3:logging-interceptor:4.8.0")
    implementation("com.google.android.play:core:1.10.0")
    implementation("org.jsoup:jsoup:1.13.1")

}