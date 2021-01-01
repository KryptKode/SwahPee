plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
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

    implementation(Libs.kotlin_stdlib)
    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)
    implementation(Libs.material)
    testImplementation(Libs.junit_junit)
    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.espresso_core)
}