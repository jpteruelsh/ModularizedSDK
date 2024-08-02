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

    js(IR) {
        nodejs()
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            api(project(":modules:CoreModule"))
        }
    }
}

android {
    namespace = "com.example.modularizedlibrary.profile"
    compileSdk = 34
}