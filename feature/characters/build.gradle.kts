plugins {
    id(ScriptsPlugins.androidLibrary)
    kotlinKapt
    daggerHilt
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

    implementation (Libs.circleimageview)
    implementation ("com.romandanylyk:pageindicatorview:1.0.3")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")

    implementation (Libs.fragment_ktx)
    implementation (Libs.timber)

    implementation (Libs.lifecycle_extensions)
    implementation (Libs.lifecycle_livedata_ktx)
    implementation (Libs.lifecycle_viewmodel_ktx)
    implementation (Libs.lifecycle_runtime_ktx)
    implementation (Libs.lifecycle_common_java8)


    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)
    implementation(Libs.hilt_lifecycle_viewmodel)
    kapt(Libs.hilt_compiler)

    androidTestImplementation (Libs.androidx_test_ext_junit)
    androidTestImplementation (Libs.espresso_core)

    testImplementation (project(Modules.testShared))
    testImplementation (Libs.junit_junit)
    testImplementation (Libs.core_testing)
    testImplementation (Libs.kotlinx_coroutines_test)
    testImplementation (Libs.truth)
}