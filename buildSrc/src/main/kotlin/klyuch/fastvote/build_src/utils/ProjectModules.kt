package klyuch.fastvote.build_src.utils

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

internal fun DependencyHandler.dataModule(name: String) = implementation(project("$name:data"))
internal fun DependencyHandler.domainModule(name: String) = implementation(project("$name:domain"))
internal fun DependencyHandler.presentationModule(name: String) = implementation(project("$name:presentation"))