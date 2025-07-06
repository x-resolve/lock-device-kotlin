plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.xresolve.lockshortcut"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.xresolve.lockshortcut"
        minSdk = 35
        targetSdk = 35
        versionCode = 14
        versionName = "1.0.21"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
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
