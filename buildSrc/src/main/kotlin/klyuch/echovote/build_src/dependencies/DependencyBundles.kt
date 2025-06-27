package klyuch.echovote.build_src.dependencies

import klyuch.echovote.build_src.utils.implementation
import klyuch.echovote.build_src.utils.testImplementation
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

fun DependencyHandler.androidx() {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.LIFECYCLE_RUNTIME_KTX)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(platform(Dependencies.COMPOSE_BOM))
    implementation(Dependencies.UI)
    implementation(Dependencies.UI_GRAPHICS)
    implementation(Dependencies.UI_TOOLING)
    implementation(Dependencies.UI_TOOLING_PREVIEW)
    implementation(Dependencies.MATERIAL)
}

fun DependencyHandler.coroutines() = implementation(Dependencies.COROUTINES)

fun DependencyHandler.koin() {
    implementation(Dependencies.KOIN_CORE)
    implementation(Dependencies.KOIN_ANDROID)
    implementation(Dependencies.KOIN_COMPOSE)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.CONVERTER_GSON)
}

fun DependencyHandler.serialization() = implementation(Dependencies.SERIALIZATION)

fun DependencyHandler.navigation() = implementation(Dependencies.NAVIGATION_COMPOSE)

fun DependencyHandler.coil() = implementation(Dependencies.COIL)

fun DependencyHandler.splashScreen() = implementation(Dependencies.SPLASH_SCREEN)

fun DependencyHandler.testing() {
    testImplementation(kotlin("test"))
    testImplementation(Dependencies.MOCKK)
    testImplementation(Dependencies.COROUTINES_TEST)
}