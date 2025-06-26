package klyuch.echovote.build_src.modules.bundles

import klyuch.echovote.build_src.modules.coreDomain
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.domainModules() {
    coreDomain()
}