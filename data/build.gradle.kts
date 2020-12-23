plugins {
    id(ScriptsPlugins.kotlinLibrary)
}

dependencies {
    implementation(Libs.kotlinx_coroutines_android)
    implementation(project(Modules.domain))
    implementation("javax.inject:javax.inject:1")
    testImplementation(project(Modules.testShared))
}