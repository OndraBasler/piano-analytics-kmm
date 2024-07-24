plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.native.cocoapods)
    id("maven-publish")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
