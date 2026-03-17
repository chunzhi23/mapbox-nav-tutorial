import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    target {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    dependencies {
        implementation(projects.composeApp)
        implementation(libs.compose.uiToolingPreview)
        implementation(libs.androidx.activity.compose)

        implementation("com.mapbox.navigationcore:copilot-ndk27:3.20.0-rc.1")
        implementation("com.mapbox.navigationcore:ui-maps-ndk27:3.20.0-rc.1")
        implementation("com.mapbox.navigationcore:voice-ndk27:3.20.0-rc.1")
        implementation("com.mapbox.navigationcore:tripdata-ndk27:3.20.0-rc.1")
        implementation("com.mapbox.navigationcore:android-ndk27:3.20.0-rc.1")
        implementation("com.mapbox.navigationcore:ui-components-ndk27:3.20.0-rc.1")
    }
}

android {
    namespace = "com.tsungmn.tutorial.mapbox_nav"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}