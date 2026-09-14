package com.reza.state_reducer_plugin

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class StateReducerPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.google.devtools.ksp")

            if (findProject(":state-reducer-annotations") != null) {
                dependencies.add("implementation", project(":state-reducer-annotations"))
                dependencies.add("ksp", project(":state-reducer-processor"))
            } else {
                dependencies.add("implementation", "io.github.RahmaniReza:state-reducer-annotations:1.0.0")
                dependencies.add("ksp", "io.github.RahmaniReza:state-reducer-processor:1.0.0")
            }

            plugins.withId("com.android.base") {
                val androidExtension = extensions.findByType(CommonExtension::class.java)
                androidExtension?.sourceSets?.all { sourceSet ->
                    val path = "${layout.buildDirectory.get().asFile}/generated/ksp/${sourceSet.name}/kotlin"
                    sourceSet.java.directories.add(path)
                }
            }
        }
    }
}