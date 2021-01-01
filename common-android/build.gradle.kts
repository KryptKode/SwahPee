plugins {
    id(ScriptsPlugins.androidLibrary)
}

dependencies {

    implementation(Libs.kotlinx_coroutines_android)
    implementation (Libs.kotlinx_coroutines_core)

    implementation(Libs.javax_inject)

    implementation (Libs.core_ktx)
    implementation (Libs.appcompat)

    implementation (Libs.material)
    implementation (Libs.constraintlayout)

    implementation (Libs.fragment_ktx)

    implementation (Libs.lifecycle_common_java8)

}