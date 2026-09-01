plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.2.1"
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
    website = "https://github.com/RahmaniReza/StateReducer"
    vcsUrl = "https://github.com/RahmaniReza/StateReducer.git"

    plugins {
        create("stateReducer") {
            id = "com.reza.statereducer"
            implementationClass = "com.reza.state_reducer_plugin.StateReducerPlugin"
            displayName = "State Reducer Plugin"
            description = "Auto-configures KSP and generated source sets for StateReducer"
            tags.set(listOf("ksp", "code-generation", "android"))
        }
    }
}
