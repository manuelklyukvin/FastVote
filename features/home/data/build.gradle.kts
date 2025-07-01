import klyuch.fastvote.build_src.configs.GradleNamespaces
import klyuch.fastvote.build_src.gradle_plugins.DataGradlePlugin
import klyuch.fastvote.build_src.modules.homeDomain
import klyuch.fastvote.build_src.modules.votesData
import klyuch.fastvote.build_src.modules.votesDomain

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

    votesData()
    votesDomain()
}