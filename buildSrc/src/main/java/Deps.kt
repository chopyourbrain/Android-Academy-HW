import org.gradle.api.JavaVersion

const val kotlinVersion = "1.4.0"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.0.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
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
        const val appcompat = "1.2.0"
        const val constraint = "2.0.0-rc1"
        const val core_ktx = "1.3.1"
        const val material = "1.2.0"
    }
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val appcompat =  "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material =  "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =  "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    const val coreKtx =  "androidx.core:core-ktx:${Versions.core_ktx}"
}