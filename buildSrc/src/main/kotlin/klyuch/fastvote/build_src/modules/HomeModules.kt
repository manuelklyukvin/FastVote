package klyuch.fastvote.build_src.modules

import klyuch.fastvote.build_src.utils.dataModule
import klyuch.fastvote.build_src.utils.domainModule
import klyuch.fastvote.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE_NAME = ":features:home"

fun DependencyHandler.homeData() = dataModule(MODULE_NAME)
fun DependencyHandler.homeDomain() = domainModule(MODULE_NAME)
fun DependencyHandler.homePresentation() = presentationModule(MODULE_NAME)