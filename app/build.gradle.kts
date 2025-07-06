plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.xresolve.lockshortcut"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.xresolve.lockshortcut"
        minSdk = 35 // Android 15 mínimo
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
}
