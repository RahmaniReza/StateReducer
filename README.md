# StateReducer

[![Maven Central](https://img.shields.io/maven-central/v/io.github.rahmanireza/state-reducer-annotations.svg)](https://central.sonatype.com/artifact/io.github.rahmanireza/state-reducer-annotations)
[![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/io.github.rahmanireza.statereducer)](https://plugins.gradle.org/plugin/io.github.RahmaniReza.statereducer)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

StateReducer is a Kotlin Symbol Processing (KSP) tool designed to automate state update methods and data class copy operations for Kotlin projects.

## Installation

### 1. Apply the Gradle Plugin

Add the plugin to your module's `build.gradle.kts`:

```kotlin
plugins {
    id("io.github.RahmaniReza.statereducer") version "1.0.0"
}
