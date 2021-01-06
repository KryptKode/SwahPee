plugins {
    id(ScriptsPlugins.androidLibrary)
    kotlinKapt
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.data))
    implementation(project(Modules.remote))
    implementation(project(Modules.cache))
    implementation(project(Modules.commonAndroid))

    implementation(Libs.room_ktx)
    implementation(Libs.room_runtime)

    implementation(Libs.appcompat)
    implementation(Libs.kotlinx_coroutines_core)
    implementation(Libs.moshi_kotlin)

    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)

    testImplementation(project(Modules.testShared))
}