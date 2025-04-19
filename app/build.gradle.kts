plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.marvel"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.marvel"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    kapt {
        correctErrorTypes = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "PUBLIC_KEY", "\"bf0b527468ed482a1340992bc7039cf7\"")
            buildConfigField("String", "PRIVATE_KEY", "\"d31130b3cfa56235a59c7d1e11cf1ff477d332bd\"")
        }
        debug {
            buildConfigField("String", "PUBLIC_KEY", "\"bf0b527468ed482a1340992bc7039cf7\"")
            buildConfigField("String", "PRIVATE_KEY", "\"d31130b3cfa56235a59c7d1e11cf1ff477d332bd\"")
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        dataBinding = true
        buildConfig = true
    }
}

dependencies {

//    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.tracing.perfetto.handshake)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.glide)
    implementation(libs.androidx.recyclerview)
    implementation(libs.filament.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.hilt.android.v2561)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v231)
    implementation(libs.androidx.lifecycle.livedata.ktx.v231)
    implementation (libs.androidx.fragment.ktx)
    implementation (libs.androidx.lifecycle.runtime.ktx.v231)
    kapt(libs.hilt.compiler)
    implementation ("com.google.dagger:hilt-android:2.56.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.56.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

}