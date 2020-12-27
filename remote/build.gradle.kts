plugins {
    id(ScriptsPlugins.kotlinLibrary)
    kotlin("kapt")
}

dependencies {
    implementation(project(Modules.data))
    implementation(Libs.kotlinx_coroutines_android)
    implementation(Libs.javax_inject)

    implementation(Libs.okhttp)
    implementation(Libs.logging_interceptor)

    implementation(Libs.moshi_kotlin)
    kapt(Libs.moshi_kotlin_codegen)

    implementation(Libs.retrofit)
    implementation(Libs.converter_moshi)

    testImplementation(project(Modules.testShared))
    testImplementation(Libs.mockwebserver)
}