import klyuch.echovote.build_src.configs.GradleNamespaces
import klyuch.echovote.build_src.configs.GradleVersions
import klyuch.echovote.build_src.dependencies.androidx
import klyuch.echovote.build_src.dependencies.coil
import klyuch.echovote.build_src.dependencies.compose
import klyuch.echovote.build_src.dependencies.navigation
import klyuch.echovote.build_src.dependencies.serialization
import klyuch.echovote.build_src.dependencies.testing
import klyuch.echovote.build_src.modules.coreDomain

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.compose)
    alias(libs.plugins.serialization)
}

android {
    namespace = GradleNamespaces.CORE
    compileSdk = GradleVersions.COMPILE_SDK

    defaultConfig {
        minSdk = GradleVersions.MIN_SDK
    }
    buildTypes {
        release {
            isMinifyEnabled = true
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

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    androidx()
    compose()
    serialization()
    navigation()
    coil()
    testing()

    coreDomain()
}