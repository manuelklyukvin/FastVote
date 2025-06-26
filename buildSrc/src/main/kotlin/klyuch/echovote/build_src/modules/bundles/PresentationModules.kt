package klyuch.echovote.build_src.modules.bundles

import klyuch.echovote.build_src.modules.corePresentation
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.presentationModules() {
    corePresentation()
}