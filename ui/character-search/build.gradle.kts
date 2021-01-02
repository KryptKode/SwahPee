plugins {
    id(ScriptsPlugins.androidLibrary)
    kotlinKapt
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
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:${Versions.androidx_lifecycle}")
    implementation (Libs.lifecycle_viewmodel_ktx)
    implementation (Libs.lifecycle_runtime_ktx)
    implementation (Libs.lifecycle_common_java8)


    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)
    implementation(Libs.hilt_lifecycle_viewmodel)
    kapt(Libs.hilt_compiler)

    androidTestImplementation (Libs.androidx_test_ext_junit)
    androidTestImplementation (Libs.espresso_core)
    testImplementation (Libs.junit_junit)
    testImplementation ("android.arch.core:core-testing:1.1.1")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.org_jetbrains_kotlinx_kotlinx_coroutines}")
    testImplementation (Libs.truth)
}