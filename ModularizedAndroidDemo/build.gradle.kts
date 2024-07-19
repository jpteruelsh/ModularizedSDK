// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}

tasks.register("buildAndCopyKmmAar") {
    doLast {
        val kmmProjectPath = "../kmm"
        val buildCommand = "./gradlew assembleRelease"

        // Execute the KMM SDK build task
        exec {
            commandLine("sh", "-c", "cd $kmmProjectPath && $buildCommand")
        }

        val aarSourcePath = "$kmmProjectPath/ModularizedSDK/build/outputs/aar/ModularizedSDK-release.aar"
        val aarTargetPath = "${project.rootDir}/app/libs"

        copy {
            from(aarSourcePath)
            into(aarTargetPath)
        }
    }
}