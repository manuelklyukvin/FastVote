import klyuch.fastvote.build_src.configs.GradleNamespaces
import klyuch.fastvote.build_src.gradle_plugins.PresentationGradlePlugin
import klyuch.fastvote.build_src.modules.homeDomain
import klyuch.fastvote.build_src.modules.votesDomain
import klyuch.fastvote.build_src.modules.votesPresentation

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

    votesDomain()
    votesPresentation()
}