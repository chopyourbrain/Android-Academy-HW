import org.gradle.api.JavaVersion

const val kotlinVersion = "1.4.0"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.0.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:1.4.20"
    const val kotlinSerialization = "org.jetbrains.kotlin.plugin.serialization"
    const val androidApplication = "com.android.application"
    const val kotlin = "kotlin"

}

object Sdk {
    const val min = 21
    const val compile = 30
    const val target = compile
    val java = JavaVersion.VERSION_1_8
}

object Project {
    const val name = "1.0.0"
    const val code = 1
}

object Libraries {
    object Versions {
        const val kotlin = kotlinVersion
        const val coroutines = "1.4.2"
        const val appcompat = "1.2.0"
        const val constraint = "2.0.0-rc1"
        const val core_ktx = "1.3.1"
        const val material = "1.2.0"
        const val kotlinSerialization = "1.0.1"
        const val koin = "2.2.1"
        const val lifecycle = "2.2.0"
        const val glide = "4.11.0"
    }
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val appcompat =  "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material =  "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =  "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val coreKtx =  "androidx.core:core-ktx:${Versions.core_ktx}"

    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    const val kotlinSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"

    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinVm = "org.koin:koin-android-viewmodel:${Versions.koin}"

    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleVm = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

}