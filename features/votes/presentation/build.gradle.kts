import klyuch.fastvote.build_src.configs.GradleNamespaces
import klyuch.fastvote.build_src.gradle_plugins.PresentationGradlePlugin
import klyuch.fastvote.build_src.modules.votesDomain

apply<PresentationGradlePlugin>()

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
}

android {
    namespace = GradleNamespaces.VOTES
}

dependencies {
    votesDomain()
}