plugins {
    id(ScriptsPlugins.kotlinLibrary)
}

dependencies {
    implementation(Libs.kotlinx_coroutines_android)
    testImplementation(Libs.junit_junit)
    testImplementation(Libs.mockk)
    testImplementation(Libs.truth)
    testImplementation(Libs.kotlinx_coroutines_test)
}