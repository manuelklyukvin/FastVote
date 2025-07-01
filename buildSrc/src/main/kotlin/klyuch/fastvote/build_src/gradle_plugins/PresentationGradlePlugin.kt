package klyuch.fastvote.build_src.gradle_plugins

import klyuch.fastvote.build_src.configs.GradleVersions
import klyuch.fastvote.build_src.dependencies.androidx
import klyuch.fastvote.build_src.dependencies.compose
import klyuch.fastvote.build_src.modules.coreDomain
import klyuch.fastvote.build_src.modules.corePresentation
import klyuch.fastvote.build_src.plugins.Plugins
import klyuch.fastvote.build_src.utils.android
import org.gradle.api.Project

class PresentationGradlePlugin : CoreGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.apply {
            plugin(Plugins.ANDROID_LIBRARY)
            plugin(Plugins.KOTLIN)
            plugin(Plugins.COMPOSE)
        }
    }

    override fun applyProjectConfigs(project: Project) {
        project.android().apply {
            compileSdk = GradleVersions.COMPILE_SDK

            defaultConfig {
                minSdk = GradleVersions.MIN_SDK
            }
            buildTypes {
                release {
                    isMinifyEnabled = true
                }
            }
            compileOptions {
                sourceCompatibility = GradleVersions.JAVA
                targetCompatibility = GradleVersions.JAVA
            }
            buildFeatures {
                compose = true
            }
        }
    }

    override fun applyDependencies(project: Project) {
        project.dependencies.apply {
            androidx()
            compose()

            coreDomain()
            corePresentation()
        }
    }
}