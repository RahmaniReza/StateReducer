plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    `java-gradle-plugin`
    `maven-publish`
}

repositories {
    google()
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}
dependencies {
    // Provide AGP, Kotlin, and KSP APIs at compile time for your plugin implementation
    compileOnly("com.android.tools.build:gradle:${libs.versions.agp.get()}")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.jetbrainsKotlinJvm.get()}")
    compileOnly("com.google.devtools.ksp:symbol-processing-gradle-plugin:${libs.versions.ksp.get()}")
}
gradlePlugin {
    plugins {
        create("stateReducer") {
            id = "com.reza.statereducer"
            implementationClass = "com.reza.state_reducer_plugin.StateReducerPlugin"
            displayName = "State Reducer Plugin"
            description = "Auto-configures KSP and generated source sets for StateReducer"
        }
    }
}
