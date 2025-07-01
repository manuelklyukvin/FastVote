import klyuch.fastvote.build_src.gradle_plugins.DomainGradlePlugin
import klyuch.fastvote.build_src.modules.votesDomain

apply<DomainGradlePlugin>()

plugins {
    alias(libs.plugins.jvm)
}

dependencies {
    votesDomain()
}