package klyuch.fastvote.build_src.gradle_plugins

import klyuch.fastvote.build_src.dependencies.testing
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.withType

open class CoreGradlePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        applyPlugins(project)
        applyProjectConfigs(project)
        applyDependencies(project)
        applyTesting(project)
    }

    protected open fun applyPlugins(project: Project) = Unit

    protected open fun applyProjectConfigs(project: Project) = Unit

    protected open fun applyDependencies(project: Project) = Unit

    private fun applyTesting(project: Project) {
        project.tasks.withType<Test> { useJUnitPlatform() }
        project.dependencies.apply { testing() }
    }
}