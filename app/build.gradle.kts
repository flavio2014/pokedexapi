plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

val retrofitVersion = "2.8.0"
val coroutinesVersion = "1.3.0"
val lifeCycleVersion = "2.2.0"
val coilVersion = "2.2.2"
val koinVersion = "3.2.2"
val pagingVersion = "3.1.1"

android {
    namespace = "br.com.pokeapidex"
    compileSdk = 34

    defaultConfig {
        applicationId = "br.com.pokeapidex"
        minSdk = 24
        targetSdk = 34
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }


}

dependencies {
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleVersion")

    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleVersion")

    // Coil
    implementation ("io.coil-kt:coil:$coilVersion")

    // Koin
    implementation ("io.insert-koin:koin-android:$koinVersion")
    implementation ("io.insert-koin:koin-android-compat:$koinVersion")
    implementation ("io.insert-koin:koin-androidx-workmanager:$koinVersion")
    implementation ("io.insert-koin:koin-androidx-navigation:$koinVersion")

    // Paging
    implementation ("androidx.paging:paging-runtime:$pagingVersion")

    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.4.1")
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}
