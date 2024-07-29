plugins {
    alias(libs.plugins.kotlinMultiplatform)
//    alias(libs.plugins.kotlinCocoapods)
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
    iosX64()
    iosArm64()
    iosSimulatorArm64()
//
//    cocoapods {
//        summary = "Some description for the Shared Module"
//        homepage = "Link to the Shared Module homepage"
//        version = "1.0"
//        ios.deploymentTarget = "16.0"
//        framework {
//            baseName = "ProfileModule"
//            isStatic = true
//        }
//    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(project(":modules:CoreModule"))
        }
        androidMain.dependencies {
            // put your android dependencies here
        }
        iosMain.dependencies {
            // put your ios dependencies here
        }
    }
}

android {
    namespace = "com.example.modularizedlibrary.profile"
    compileSdk = 34
}