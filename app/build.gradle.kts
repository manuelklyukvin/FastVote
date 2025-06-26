import klyuch.echovote.build_src.configs.GradleNamespaces
import klyuch.echovote.build_src.configs.GradleVersions
import klyuch.echovote.build_src.dependencies.androidx
import klyuch.echovote.build_src.dependencies.coil
import klyuch.echovote.build_src.dependencies.compose
import klyuch.echovote.build_src.dependencies.koin
import klyuch.echovote.build_src.dependencies.splashScreen
import klyuch.echovote.build_src.modules.bundles.dataModules
import klyuch.echovote.build_src.modules.bundles.domainModules
import klyuch.echovote.build_src.modules.bundles.presentationModules

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose)
}

android {
    namespace = GradleNamespaces.APP
    compileSdk = GradleVersions.COMPILE_SDK

    defaultConfig {
        applicationId = GradleNamespaces.APP
        minSdk = GradleVersions.MIN_SDK
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
    compileOptions {
        sourceCompatibility = GradleVersions.JAVA
        targetCompatibility = GradleVersions.JAVA
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    androidx()
    compose()
    koin()
    coil()
    splashScreen()

    dataModules()
    domainModules()
    presentationModules()
}