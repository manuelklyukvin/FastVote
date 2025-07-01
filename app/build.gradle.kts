import klyuch.fastvote.build_src.configs.GradleNamespaces
import klyuch.fastvote.build_src.configs.GradleVersions
import klyuch.fastvote.build_src.dependencies.androidx
import klyuch.fastvote.build_src.dependencies.coil
import klyuch.fastvote.build_src.dependencies.compose
import klyuch.fastvote.build_src.dependencies.koin
import klyuch.fastvote.build_src.dependencies.retrofit
import klyuch.fastvote.build_src.dependencies.splashScreen
import klyuch.fastvote.build_src.modules.bundles.dataModules
import klyuch.fastvote.build_src.modules.bundles.domainModules
import klyuch.fastvote.build_src.modules.bundles.presentationModules

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
    retrofit()
    koin()
    coil()
    splashScreen()

    dataModules()
    domainModules()
    presentationModules()
}