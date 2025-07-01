package klyuch.fastvote.build_src.modules.bundles

import klyuch.fastvote.build_src.modules.coreDomain
import klyuch.fastvote.build_src.modules.homeDomain
import klyuch.fastvote.build_src.modules.votesDomain
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.domainModules() {
    coreDomain()

    votesDomain()

    homeDomain()
}