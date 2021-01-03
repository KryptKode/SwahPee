plugins {
    id(ScriptsPlugins.kotlinLibrary)
}

dependencies {
    implementation(Libs.kotlinx_coroutines_android)
    implementation(Libs.javax_inject)
    testImplementation(project(Modules.testShared))
}