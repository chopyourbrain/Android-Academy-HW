plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinSerialization)
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Sdk.compile)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "ru.example.android_academy_hw"
        minSdkVersion(Sdk.min)
        targetSdkVersion(Sdk.target)
        versionCode = Project.code
        versionName = Project.name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        targetCompatibility = Sdk.java
        sourceCompatibility = Sdk.java
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Libraries.kotlin)
    implementation(Libraries.coroutinesAndroid)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coreKtx)
    implementation(Libraries.appcompat)
    implementation(Libraries.material)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.kotlinSerializationJson)
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinVm)
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.lifecycleVm)
    implementation(Libraries.lifecycleLivedata)
    implementation(Libraries.glide)
    annotationProcessor(Libraries.glideCompiler)

    testImplementation ("junit:junit:4.13.1")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
}