// Gradle currently does not allow loading in the "plugins" or "buildscript" blocks
// declarations not in the root module.
// For a better package structure this calls should be in a smaller "ext" package
// but at the moment we need this hack to be able to publicly expose them
//
// See https://github.com/gradle/gradle/issues/9270 for details.
@file:Suppress("PackageDirectoryMismatch")

import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = id(GradlePluginId.ANDROID_APPLICATION)

val PluginDependenciesSpec.androidLibrary: PluginDependencySpec
    get() = id(ScriptsPlugins.androidLibrary)

val PluginDependenciesSpec.kotlinAndroid: PluginDependencySpec
    get() = id(GradlePluginId.KOTLIN_ANDROID)

val PluginDependenciesSpec.kotlin: PluginDependencySpec
    get() = id(GradlePluginId.KOTLIN)

val PluginDependenciesSpec.kotlinParcelize: PluginDependencySpec
    get() = id(GradlePluginId.KOTLIN_PARCELIZE)

val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = id(GradlePluginId.KOTLIN_KAPT)

val PluginDependenciesSpec.navigationSafeArgs: PluginDependencySpec
    get() = id("androidx.navigation.safeargs")

val PluginDependenciesSpec.daggerHilt: PluginDependencySpec
    get() = id("dagger.hilt.android.plugin")
