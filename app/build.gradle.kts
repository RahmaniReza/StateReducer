plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

/*kotlin {
    sourceSets.configureEach {
        kotlin.srcDir("build/generated/ksp/$name/kotlin")
    }
}*/

kotlin {
    sourceSets.configureEach {
        // Automatically registers KSP outputs for all variants (debug, release, etc.)
        kotlin.srcDir(layout.buildDirectory.dir("generated/ksp/$name/kotlin"))
    }
}

android {
    namespace = "com.reza.statereducer"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.reza.statereducer"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    ksp(project(":state-reducer-processor"))
    implementation(project(":state-reducer-annotations"))

    // 2. Hilt Dependency Injection (using KSP)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // 3. Compose Dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.lifecycle.runtime.compose)
    
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}