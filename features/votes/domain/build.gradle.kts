import klyuch.fastvote.build_src.gradle_plugins.DomainGradlePlugin

apply<DomainGradlePlugin>()

plugins {
    alias(libs.plugins.jvm)
}