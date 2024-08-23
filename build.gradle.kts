// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    // Hilt
    alias(libs.plugins.hilt.android) apply false

    // Safe args
    id ("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false
}