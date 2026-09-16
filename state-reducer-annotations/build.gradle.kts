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

mavenPublishing {
    coordinates("io.github.rahmanireza", "state-reducer-annotations", "1.0.0")

    pom {
        name.set("StateReducer Annotations")
        description.set("Annotations for the StateReducer KSP code generator")
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
