import klyuch.echovote.build_src.configs.GradleNamespaces
import klyuch.echovote.build_src.gradle_plugins.DataGradlePlugin
import klyuch.echovote.build_src.modules.homeDomain

apply<DataGradlePlugin>()

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