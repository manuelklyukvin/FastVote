package klyuch.echovote.build_src.gradle_plugins

import klyuch.echovote.build_src.configs.GradleVersions
import klyuch.echovote.build_src.dependencies.androidx
import klyuch.echovote.build_src.dependencies.retrofit
import klyuch.echovote.build_src.modules.coreData
import klyuch.echovote.build_src.modules.coreDomain
import klyuch.echovote.build_src.plugins.Plugins
import klyuch.echovote.build_src.utils.android
import org.gradle.api.Project

class DataGradlePlugin : CoreGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.apply {
            plugin(Plugins.ANDROID_LIBRARY)
            plugin(Plugins.KOTLIN)
        }
    }

    override fun applyProjectConfigs(project: Project) {
        project.android().apply {
            compileSdk = GradleVersions.COMPILE_SDK

            defaultConfig {
                minSdk = GradleVersions.MIN_SDK
            }
            compileOptions {
                sourceCompatibility = GradleVersions.JAVA
                targetCompatibility = GradleVersions.JAVA
            }
        }
    }

    override fun applyDependencies(project: Project) {
        project.dependencies.apply {
            androidx()
            retrofit()

            coreData()
            coreDomain()
        }
    }
}