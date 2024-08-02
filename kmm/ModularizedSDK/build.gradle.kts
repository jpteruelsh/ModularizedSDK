import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    val xcframeworkName = "ModularizedSDK"
    val xcf = XCFramework(xcframeworkName)

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName

            // Specify CFBundleIdentifier to uniquely identify the framework
            binaryOption("bundleId", "org.example.${xcframeworkName}")
            xcf.add(this)
            isStatic = true
            export(project(":modules:CoreModule"))
            export(project(":modules:ProfileModule"))
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            api(project(":modules:CoreModule"))
            api(project(":modules:ProfileModule"))
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
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