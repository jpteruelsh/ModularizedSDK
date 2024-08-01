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
include(":ModularizedSDK")
project(":ModularizedSDK").projectDir = file("../kmm/ModularizedSDK")
include(":modules:CoreModule")
project(":modules:CoreModule").projectDir = file("../kmm/modules/CoreModule")
include(":modules:ProfileModule")
project(":modules:ProfileModule").projectDir = file("../kmm/modules/ProfileModule")
