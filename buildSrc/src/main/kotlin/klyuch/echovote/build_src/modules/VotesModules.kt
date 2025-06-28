package klyuch.echovote.build_src.modules

import klyuch.echovote.build_src.utils.dataModule
import klyuch.echovote.build_src.utils.domainModule
import klyuch.echovote.build_src.utils.presentationModule
import org.gradle.api.artifacts.dsl.DependencyHandler

private const val MODULE_NAME = ":features:votes"

fun DependencyHandler.votesData() = dataModule(MODULE_NAME)
fun DependencyHandler.votesDomain() = domainModule(MODULE_NAME)
fun DependencyHandler.votesPresentation() = presentationModule(MODULE_NAME)