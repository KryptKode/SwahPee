plugins {
    androidLibrary
    kotlinKapt
}

android {

    defaultConfig {
        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }

    sourceSets {
        getByName("androidTest").assets.srcDirs("$projectDir/schemas")
    }
}

dependencies {

    implementation(project(Modules.data))

    implementation(Libs.work_runtime_ktx)
    androidTestImplementation(Libs.work_testing)

    implementation(Libs.hilt_work)
    kapt(Libs.hilt_compiler)

    implementation(Libs.moshi_kotlin)

    implementation(Libs.room_ktx)
    implementation(Libs.room_runtime)
    kapt(Libs.room_compiler)

    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.espresso_core)

    testImplementation(project(Modules.testShared))
}