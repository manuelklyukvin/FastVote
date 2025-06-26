import klyuch.echovote.build_src.configs.GradleNamespaces
import klyuch.echovote.build_src.configs.GradleVersions
import klyuch.echovote.build_src.dependencies.retrofit
import klyuch.echovote.build_src.dependencies.testing
import klyuch.echovote.build_src.modules.coreDomain

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
}

android {
    namespace = GradleNamespaces.CORE
    compileSdk = GradleVersions.COMPILE_SDK

    defaultConfig {
        minSdk = GradleVersions.MIN_SDK
    }
    compileOptions {
        sourceCompatibility = GradleVersions.JAVA
        targetCompatibility = GradleVersions.JAVA
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    retrofit()
    testing()

    coreDomain()
}