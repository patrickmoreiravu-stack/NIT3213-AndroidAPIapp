plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.androidapiapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.androidapiapp"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation("androidx.recyclerview:recyclerview:1.4.0")

    //Retrofit + Moshi
    implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation("com.squareup.retrofit2:converter-moshi:3.0.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.15.2")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.57.1")
    kapt("com.google.dagger:hilt-android-compiler:2.57.1")

    //Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.3")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.9.3")


    //Testing Dependencies
    //JUnit
    testImplementation("junit:junit:4.13.2")

    //AndroidX Test - Core & Rules
    testImplementation("androidx.arch.core:core-testing:2.2.0")

    //Coroutines Test
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.2")

    //Mockito
    testImplementation("org.mockito:mockito-core:5.19.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:6.0.0")

    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    testImplementation(kotlin("test"))
}