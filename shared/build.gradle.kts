import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.kotlinSerialization)
}

// Génère un fichier AppVersion.kt à partir du numéro de version défini dans libs.versions.toml,
// pour que le code commun (Android + iOS) puisse afficher la version sans la dupliquer.
val generateAppVersion by tasks.registering {
    val outputDir = layout.buildDirectory.dir("generated/appversion")
    outputs.dir(outputDir)
    val versionName = libs.versions.appVersionName.get()
    val versionCode = libs.versions.appVersionCode.get()
    doLast {
        val file = outputDir.get().asFile.resolve("com/fabien/trivia/AppVersion.kt")
        file.parentFile.mkdirs()
        file.writeText(
            """
            |package com.fabien.trivia
            |
            |object AppVersion {
            |    const val NAME: String = "$versionName"
            |    const val CODE: Int = $versionCode
            |}
            |
            """.trimMargin()
        )
    }
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    android {
       namespace = "com.fabien.trivia.shared"
       compileSdk = libs.versions.android.compileSdk.get().toInt()
       minSdk = libs.versions.android.minSdk.get().toInt()
    
       compilerOptions {
           // JVM 17 requis : Firebase BoM 34.x est compilé en bytecode 17 (fonctions inline).
           jvmTarget = JvmTarget.JVM_17
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
    }
    
    sourceSets {
        commonMain {
            kotlin.srcDir(generateAppVersion)
        }
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.sqldelight.android.driver)
            // BoM Firebase : fixe les versions des SDK natifs Android (firebase-auth,
            // firebase-common) que GitLive déclare sans version.
            implementation(project.dependencies.platform(libs.firebase.bom))
        }
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
            implementation(libs.sqldelight.runtime)
            implementation(libs.compose.material.icons.core)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.core)
            // GitLive Firebase Kotlin SDK (auth + firestore). iOS : nécessite de linker les pods
            // Firebase côté iosApp (voir Podfile) ; Android : auto-init via google-services.json.
            implementation(libs.firebase.auth)
            implementation(libs.firebase.firestore)
        }
        iosMain.dependencies {
            implementation(libs.sqldelight.native.driver)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}

sqldelight {
    databases {
        create("TriviaDatabase") {
            packageName.set("com.fabien.trivia.data")
        }
    }
}