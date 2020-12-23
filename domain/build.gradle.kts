plugins {
    id(ScriptsPlugins.kotlinLibrary)
}

dependencies {
    implementation(Libs.kotlinx_coroutines_android)
    testImplementation(project(Modules.testShared))
}