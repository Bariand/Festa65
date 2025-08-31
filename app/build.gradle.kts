plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.festa65"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.festa65"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // Necessário para Google Maps API
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.google.android.gms:play-services-maps:18.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
}
