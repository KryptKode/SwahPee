// Top-level build file where you can add configuration options common to all sub-projects/modules.
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath(GradlePlugin.DAGGER_HILT_ANDROID_GRADLE_PLUGIN)
        classpath(GradlePlugin.NAVIGATION_SAFE_ARGS_GRADLE_PLUGIN)
    }
}

plugins {
    buildSrcVersions
    id(ScriptsPlugins.quality)
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs +=
            "-Xuse-experimental=" +
                    "kotlin.Experimental," +
                    "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                    "kotlinx.coroutines.InternalCoroutinesApi," +
                    "kotlinx.coroutines.ObsoleteCoroutinesApi," +
                    "kotlinx.coroutines.FlowPreview"
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
