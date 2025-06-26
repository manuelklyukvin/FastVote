import klyuch.echovote.build_src.configs.GradleNamespaces
import klyuch.echovote.build_src.gradle_plugins.PresentationGradlePlugin
import klyuch.echovote.build_src.modules.homeDomain

apply<PresentationGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
}

android {
    namespace = GradleNamespaces.HOME
}

dependencies {
    homeDomain()
}