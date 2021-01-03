plugins {
    id(ScriptsPlugins.kotlinLibrary)
    kotlinKapt
}

dependencies {
    implementation(project(Modules.domain))

    implementation(Libs.kotlinx_coroutines_android)
    implementation(Libs.javax_inject)
    
    testImplementation(project(Modules.testShared))
}