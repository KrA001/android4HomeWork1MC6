plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    // Safe args
    id ("androidx.navigation.safeargs.kotlin")

    // Hilt
    alias(libs.plugins.hilt.android)

    // Kapt
    kotlin("kapt")
}

android {
    namespace = "com.example.android4homework1mc6"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.android4homework1mc6"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    //binding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Core
    implementation(libs.androidx.core.ktx)

    // AppCompat
    implementation(libs.androidx.appcompat)

    // Material Components
    implementation(libs.material)

    // Activity
    implementation(libs.androidx.activity)

    // UI Components
    implementation(libs.androidx.constraintlayout)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)

    // OkHttp
    implementation(platform(libs.okHttp.bom))
    implementation(libs.okHttp)
    implementation(libs.okHttp.loggingInterceptor)

    // Lifecycle
    implementation(libs.androidx.lifecycle.runtime)
    implementation(libs.androidx.lifecycle.viewModel)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //navGraph
    val nav_version = "2.7.7"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Paging
    val paging_version = "3.2.1"
    implementation("androidx.paging:paging-runtime:$paging_version")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

// Binding property delegate
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.9")
}