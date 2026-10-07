# StateReducer

[![Maven Central](https://img.shields.io/maven-central/v/io.github.rahmanireza/state-reducer-annotations.svg?color=blue)](https://central.sonatype.com/artifact/io.github.rahmanireza/state-reducer-annotations)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.rahmanireza/state-reducer-annotations.svg?color=blue)](https://central.sonatype.com/artifact/io.github.rahmanireza/state-reducer-processor)
[![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/io.github.rahmanireza.statereducer?color=purple)](https://plugins.gradle.org/plugin/io.github.RahmaniReza.statereducer)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.3.0+-7F52FF.svg?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![KSP](https://img.shields.io/badge/KSP-Supported-green.svg)](https://github.com/google/ksp)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

**StateReducer** is a lightweight Kotlin Symbol Processing (KSP) tool that generates compile-time state reducer functions and copy helpers for deeply nested UI/domain data classes. Say goodbye to verbose `.copy()` calls in MVI/Unidirectional Data Flow architectures.

## 💡 Why StateReducer?

Updating deeply nested data classes in Unidirectional Data Flow (UDF) or MVI architectures using standard Kotlin `.copy()` is verbose, error-prone, and hard to read. **StateReducer** automates this boilerplate with type-safe, auto-generated updater functions.

### 🔴 Before (Standard Kotlin `.copy()`)

```kotlin
// Updating a deeply nested property requires nesting multiple copy calls
val updatedState = currentState.copy(
    user = currentState.user.copy(
        profile = currentState.user.profile.copy(
            settings = currentState.user.profile.settings.copy(
                isDarkMode = true
            )
        )
    )
)
```

### 🟢 AFTER (With StateReducer)

```kotlin
// 1. Define your data class hierarchy with @GenerateUpdaters
@GenerateUpdaters
data class UiState(
    val user: User = User(),
    val isLoading: Boolean = false
)

@GenerateUpdaters
data class User(
    val profile: Profile = Profile()
)

@GenerateUpdaters
data class Profile(
    val settings: Settings = Settings()
)

data class Settings(
    val isDarkMode: Boolean = false
)

class MainViewModel : ViewModel() {
    
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    // 2. Updating nested state cleanly with StateReducer inside _uiState.update { }
    fun toggleDarkMode(enabled: Boolean) {
        _uiState.update { currentState ->
            currentState.updateUser {
                updateProfile {
                    updateSettings {
                        updateIsDarkMode(enabled)
                    }
                }
            }
        }
    }
}
```
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