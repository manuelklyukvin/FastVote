package klyuch.fastvote.build_src.modules.bundles

import klyuch.fastvote.build_src.modules.coreData
import klyuch.fastvote.build_src.modules.homeData
import klyuch.fastvote.build_src.modules.votesData
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dataModules() {
    coreData()

    votesData()

    homeData()
}