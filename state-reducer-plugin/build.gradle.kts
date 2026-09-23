plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "1.2.1"
}

group = "io.github.RahmaniReza"
version = "1.0.1"

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
    // Keep compileOnly for AGP & Kotlin if consumers are required to apply them first
    compileOnly("com.android.tools.build:gradle:${libs.versions.agp.get()}")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.jetbrainsKotlinJvm.get()}")

    // Use implementation so KSP is bundled on your plugin's classpath at runtime
    implementation("com.google.devtools.ksp:symbol-processing-gradle-plugin:${libs.versions.ksp.get()}")
}

gradlePlugin {
    website = "https://github.com/RahmaniReza/StateReducer"
    vcsUrl = "https://github.com/RahmaniReza/StateReducer.git"

    plugins {
        create("stateReducer") {
            id = "io.github.RahmaniReza.statereducer"
            implementationClass = "com.reza.state_reducer_plugin.StateReducerPlugin"
            displayName = "State Reducer Plugin"
            description = "Auto-configures KSP and generated source sets for StateReducer"
            tags.set(listOf("ksp", "code-generation", "android"))
        }
    }
}
