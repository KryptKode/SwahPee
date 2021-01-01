package commonscripts

plugins {
    id("com.android.library") apply false
    id("kotlin-android") apply false
    id("kotlin-parcelize") apply false
}

android {
    compileSdkVersion(Config.compileSdk)

    defaultConfig {
        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
    }

    buildTypes {
        buildTypes {
            getByName(BuildTypes.DEBUG) {
                isMinifyEnabled = false
                isDebuggable = true
            }
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
    implementation(Libs.kotlin_stdlib)
}
