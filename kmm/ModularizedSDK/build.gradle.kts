import dev.petuska.npm.publish.task.NpmPackTask
import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinJsCompilerType
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.npmPublish)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    val libName = "ModularizedSDK"
    val xcf = XCFramework(libName)

    version = "0.0.2"

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = libName

            // Specify CFBundleIdentifier to uniquely identify the framework
            binaryOption("bundleId", "org.example.${libName}")
            xcf.add(this)
            isStatic = true
            export(project(":modules:CoreModule"))
            export(project(":modules:ProfileModule"))
        }
    }

    js {
        compilations["main"].packageJson {
            customField("exports", mapOf(
                "." to "ModularizedSDK.mjs",
                "./CoreModule" to "./ModularizedLibrary-modules-CoreModule.mjs"
            ))
        }
        moduleName = libName
        useEsModules()
        nodejs()
        binaries.library()

    }
    
    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(project(":modules:CoreModule"))
            implementation(project(":modules:ProfileModule"))
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jsMain.dependencies {

        }
    }
}

android {
    namespace = "com.example.modularizedlibrary"
    compileSdk = 34
    defaultConfig {
        minSdk = 29
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.register<Copy>("updateSPM") {
    dependsOn("assembleXCFramework")
    val xcfName = "ModularizedSDK.xcframework"
    val sourceDir = "$buildDir/XCFrameworks/release/$xcfName"
    val targetDir = "../outputs/ios-spm/Sources/$xcfName"
    from(sourceDir)
    into(targetDir)
    doLast {
        println("XCFramework copied to $targetDir")
    }
}