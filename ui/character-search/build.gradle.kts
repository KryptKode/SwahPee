plugins {
    id(ScriptsPlugins.androidLibrary)
}

dependencies {
    implementation(project(Modules.domain))
    implementation(project(Modules.commonAndroid))

    implementation(Libs.kotlinx_coroutines_android)
    implementation (Libs.kotlinx_coroutines_core)

    implementation(Libs.javax_inject)

    implementation (Libs.core_ktx)
    implementation (Libs.appcompat)

    implementation (Libs.material)
    implementation (Libs.constraintlayout)

    implementation (Libs.fragment_ktx)

    implementation (Libs.lifecycle_extensions)
    implementation (Libs.lifecycle_viewmodel_ktx)
    implementation (Libs.lifecycle_runtime_ktx)
    implementation (Libs.lifecycle_common_java8)


    androidTestImplementation (Libs.androidx_test_ext_junit)
    androidTestImplementation (Libs.espresso_core)
    testImplementation (Libs.junit_junit)
}