// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Apply plugins with version catalog alias (now using valid identifiers)
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinKapt) apply false
    alias(libs.plugins.hilt) // Hilt plugin is applied only in the app module
}

// No additional configuration needed at the top level for this simple project.
