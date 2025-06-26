package klyuch.echovote.build_src.modules.bundles

import klyuch.echovote.build_src.modules.coreData
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.dataModules() {
    coreData()
}