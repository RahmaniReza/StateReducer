plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    id("com.vanniktech.maven.publish")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {
    // Standard project dependency ensures compilation works locally before remote publishing
    api(project(":state-reducer-annotations"))

    implementation(libs.ksp.api)
    implementation(libs.kotlinpoet)
    implementation(libs.kotlinpoet.ksp)
}

mavenPublishing {
    coordinates("io.github.RahmaniReza", "state-reducer-processor", "1.0.0")

    pom {
        name.set("StateReducer Processor")
        description.set("KSP symbol processor for generating state update methods")
        url.set("https://github.com/RahmaniReza/StateReducer")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("RahmaniReza")
                name.set("Reza")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/RahmaniReza/StateReducer.git")
            developerConnection.set("scm:git:ssh://github.com/RahmaniReza/StateReducer.git")
            url.set("https://github.com/RahmaniReza/StateReducer")
        }
    }

    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}