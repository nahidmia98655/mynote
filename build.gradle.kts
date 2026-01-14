// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Apply plugins with version catalog alias (now using valid identifiers)
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinKapt) apply false
    // Hilt plugin is applied only in the app module via version catalog
    // (no need to apply it here, but we need its classpath for resolution)
}

// Explicitly add the Hilt Gradle plugin classpath so that the plugin can be resolved
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.48")
    }
}

// No additional configuration needed at the top level for this simple project.
