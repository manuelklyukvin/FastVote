package klyuch.fastvote.build_src.modules.bundles

import klyuch.fastvote.build_src.modules.corePresentation
import klyuch.fastvote.build_src.modules.homePresentation
import klyuch.fastvote.build_src.modules.votesPresentation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.presentationModules() {
    corePresentation()

    votesPresentation()

    homePresentation()
}