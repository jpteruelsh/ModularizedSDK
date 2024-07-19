pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ModularizedAndroidDemo"
include(":app")
includeBuild("../ModularizedLibrary") {
    dependencySubstitution {
        substitute(module("com.example.modularizedlibrary:ModularizedLibrary")).using(project(":"))
    }
}
//include(":ModularizedSDK")
//project(":ModularizedSDK").projectDir = file("../ModularizedLibrary/ModularizedSDK")