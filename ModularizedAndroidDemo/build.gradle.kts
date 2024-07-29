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

        val modulesDir = file("$kmmProjectPath/modules")
        val modules = modulesDir.listFiles()?.filter { it.isDirectory }?.map { it.name } ?: emptyList()
        val modulesSourcePaths = modules.map { "$kmmProjectPath/modules/$it/build/outputs/aar/$it-release.aar" }
        val mainSourcePath = "$kmmProjectPath/ModularizedSDK/build/outputs/aar/ModularizedSDK-release.aar"

        val aarSourcePaths = listOf(mainSourcePath) + modulesSourcePaths
        val aarTargetPath = "${project.rootDir}/app/libs"

        aarSourcePaths.forEach { aarSourcePath ->
            copy {
                from(aarSourcePath)
                into(aarTargetPath)
            }
        }
    }
}