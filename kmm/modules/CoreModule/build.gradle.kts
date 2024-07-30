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
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
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
    namespace = "com.example.modularizedlibrary.core"
    compileSdk = 34
}