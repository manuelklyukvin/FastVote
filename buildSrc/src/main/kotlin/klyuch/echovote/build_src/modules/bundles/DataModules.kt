package klyuch.echovote.build_src.modules.bundles

import klyuch.echovote.build_src.modules.coreData
import klyuch.echovote.build_src.modules.homeData
import klyuch.echovote.build_src.modules.votesData
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dataModules() {
    coreData()

    votesData()

    homeData()
}