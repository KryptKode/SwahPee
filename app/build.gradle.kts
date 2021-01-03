plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    daggerHilt
}

android {
    compileSdkVersion(Config.compileSdk)

    defaultConfig {
        applicationId("com.kryptkode.swahpee")
        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        buildTypes {
            getByName(BuildTypes.RELEASE) {
                isMinifyEnabled = true
            }
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Modules.commonAndroid))
    implementation(project(Modules.characterSearch))
    implementation(project(Modules.core))
    implementation(project(Modules.domain))
    implementation(project(Modules.data))
    implementation(project(Modules.remote))

    implementation(Libs.kotlin_stdlib)
    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)

    implementation(Libs.moshi_kotlin)

    implementation(Libs.constraintlayout)
    implementation(Libs.material)

    implementation(Libs.navigation_fragment_ktx)
    implementation(Libs.navigation_ui_ktx)


    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)
    implementation(Libs.hilt_lifecycle_viewmodel)
    kapt(Libs.hilt_compiler)

    testImplementation(Libs.junit_junit)
    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.espresso_core)
}