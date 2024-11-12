// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.android.application) apply true
    alias(libs.plugins.kotlin.android) apply true
    id("com.google.dagger.hilt.android") version "2.51.1" apply true
}
