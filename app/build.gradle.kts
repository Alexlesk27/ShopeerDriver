plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.android.libraries.mapsplatform.secrets.gradle.plugin)
}

android {
    namespace = "com.example.shopeerdriver"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.shopeerdriver"
        minSdk = 24

        //noinspection ExpiredTargetSdkVersion
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.google.android.gms:play-services-maps:18.1.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")

    // Koin main features for Android (Scope,ViewModel ...)
    implementation ("io.insert-koin:koin-android:3.1.2")
    // Koin Java Compatibility
    implementation ("io.insert-koin:koin-android-compat:3.1.2")
    // Koin for Jetpack WorkManager
    implementation ("io.insert-koin:koin-androidx-workmanager:3.1.2")
    // Koin for Jetpack Compose
    implementation ("io.insert-koin:koin-androidx-compose:3.1.2")


    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.4")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.4")

    implementation ("androidx.fragment:fragment-ktx:1.8.5")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:1.4.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:1.4.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
}