import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.googleDaggerHiltAndroid)
    alias(libs.plugins.googleDevToolsKsp)
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.flexath.corner"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.flexath.corner"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            val p = Properties()
            p.load(project.rootProject.file("local.properties").reader())
            val firebaseServerWebId: String = p.getProperty("FIREBASE_SERVER_SIDE_ID")
            buildConfigField("String", "FIREBASE_SERVER_SIDE_ID", "\"$firebaseServerWebId\"")
        }

        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            val p = Properties()
            p.load(project.rootProject.file("local.properties").reader())
            val firebaseServerWebId: String = p.getProperty("FIREBASE_SERVER_SIDE_ID")
            buildConfigField("String", "FIREBASE_SERVER_SIDE_ID", "\"$firebaseServerWebId\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
    kotlinOptions {
        jvmTarget = "18"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.11"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // For Shared Element Transition
    implementation(libs.androidx.compose.animation)
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit)
    testImplementation(libs.junit.v412)
    testImplementation(libs.junit.junit.v412)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Local unit tests
    testImplementation(libs.androidx.core)
    testImplementation(libs.junit)
    testImplementation(libs.androidx.core.testing)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.truth)
    testImplementation(libs.mockwebserver)
    testImplementation(libs.mockk)
    debugImplementation(libs.ui.test.manifest)

//    // Instrumentation tests
//    androidTestImplementation(libs.hilt.android.testing)
//    kspAndroidTest(libs.hilt.android.compiler)
//    androidTestImplementation(libs.junit)
//    androidTestImplementation(libs.kotlinx.coroutines.test.v151)
//    androidTestImplementation(libs.androidx.core.testing.v210)
//    androidTestImplementation(libs.truth)
//    androidTestImplementation(libs.androidx.junit.v113)
//    androidTestImplementation(libs.core.ktx)
//    androidTestImplementation(libs.mockwebserver)
//    androidTestImplementation(libs.mockk.android)
//    androidTestImplementation(libs.androidx.runner)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.androidx.material.icons.extended)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.gson)
    implementation(libs.okhttp)

    // Logging Interceptor
    implementation(libs.logging.interceptor)

    // ViewModel and LiveData for MVVM architecture
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Dagger Hilt
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    // Room
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    // Navigation Component
    implementation(libs.androidx.navigation.compose)

    // Coil for image loading
    implementation(libs.coil.compose)

    //Splash Api
    implementation(libs.androidx.core.splashscreen)

    // To Change Status Bar Color
    implementation(libs.accompanist.systemuicontroller)

    //Datastore
    implementation(libs.androidx.datastore.preferences)

    //Compose Foundation
    implementation(libs.androidx.foundation)

    //Accompanist
    implementation(libs.accompanist.systemuicontroller)

    //Paging 3
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)

    implementation(libs.accompanist.flowlayout)

    // firebase
    implementation(platform(libs.firebase.bom))

    implementation(libs.firebase.auth)
    implementation(libs.play.services.auth)
    implementation(libs.firebase.auth.ktx)

    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    
    // facebook sdk
    implementation(libs.facebook.android.sdk)
    
    // window sizes
    implementation(libs.androidx.material3.window)
}