package com.reza.state_reducer_plugin

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
                dependencies.add("implementation", "com.reza:state-reducer-annotations:1.0.0")
                dependencies.add("ksp", "com.reza:state-reducer-processor:1.0.0")
            }
        }
    }
}