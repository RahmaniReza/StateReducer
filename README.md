# StateReducer

[![Maven Central](https://img.shields.io/maven-central/v/io.github.rahmanireza/state-reducer-annotations.svg?color=blue)](https://central.sonatype.com/artifact/io.github.rahmanireza/state-reducer-annotations)
[![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/io.github.rahmanireza.statereducer?color=purple)](https://plugins.gradle.org/plugin/io.github.RahmaniReza.statereducer)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.3.0+-7F52FF.svg?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![KSP](https://img.shields.io/badge/KSP-Supported-green.svg)](https://github.com/google/ksp)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

**StateReducer** is a lightweight Kotlin Symbol Processing (KSP) tool that generates compile-time state reducer functions and copy helpers for deeply nested UI/domain data classes. Say goodbye to verbose `.copy()` calls in MVI/Unidirectional Data Flow architectures.

---

## ⚡ Key Features

- **Boilerplate Elimination:** Automatically generates type-safe updater extensions for Kotlin data classes.
- **KSP-Powered:** Fast compile-time generation with zero reflection cost at runtime.
- **KMP Compatible:** Works across Android, iOS, Desktop, and Web Kotlin Multiplatform targets.
- **Gradle Plugin Included:** Zero-overhead setup using our dedicated Gradle plugin.

---

## 🚀 Quick Setup

### Prerequisites

- **Kotlin:** `2.3.0` or higher

### 1. Apply the Gradle Plugin

In your module's `build.gradle.kts`:

```kotlin
plugins {
    id("io.github.RahmaniReza.statereducer") version "1.0.7"
}