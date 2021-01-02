plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
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

    implementation(Libs.kotlin_stdlib)
    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)

    implementation(Libs.constraintlayout)
    implementation(Libs.material)

    implementation(Libs.navigation_fragment_ktx)
    implementation(Libs.navigation_ui_ktx)

    testImplementation(Libs.junit_junit)
    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.espresso_core)

    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
    kapt ("androidx.hilt:hilt-compiler:1.0.0-alpha02")
}