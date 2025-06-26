package klyuch.echovote.build_src.modules.bundles

import klyuch.echovote.build_src.modules.coreDomain
import klyuch.echovote.build_src.modules.homeDomain
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.domainModules() {
    coreDomain()

    homeDomain()
}