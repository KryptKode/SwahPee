plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    jcenter()
    google()
}

object Dependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:4.1.1"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21"
}

dependencies {
    implementation(Dependencies.androidGradlePlugin)
    implementation(Dependencies.kotlinGradlePlugin)
}