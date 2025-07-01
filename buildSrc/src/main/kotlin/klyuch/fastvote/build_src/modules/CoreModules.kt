package klyuch.fastvote.build_src.modules

import klyuch.fastvote.build_src.utils.dataModule
import klyuch.fastvote.build_src.utils.domainModule
import klyuch.fastvote.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE_NAME = ":core"

fun DependencyHandler.coreData() = dataModule(MODULE_NAME)
fun DependencyHandler.coreDomain() = domainModule(MODULE_NAME)
fun DependencyHandler.corePresentation() = presentationModule(MODULE_NAME)