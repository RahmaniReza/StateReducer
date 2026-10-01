package com.reza.state_reducer_plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class StateReducerPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            if (!pluginManager.hasPlugin("com.google.devtools.ksp")) {
                pluginManager.apply("com.google.devtools.ksp")
            }

            if (findProject(":state-reducer-annotations") != null) {
                dependencies.add("implementation", project(":state-reducer-annotations"))
                dependencies.add("ksp", project(":state-reducer-processor"))
            } else {
                dependencies.add("implementation", "io.github.rahmanireza:state-reducer-annotations:1.0.0")
                dependencies.add("ksp", "io.github.rahmanireza:state-reducer-processor:1.0.1")
            }
        }
    }
}