@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "ru.glebik.core.db"
    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.room)
    kapt(libs.room.kapt)

    implementation(libs.kotlinx.coroutines.core)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.koin.compose)
    implementation(libs.koin)

    implementation(libs.kotlinx.coroutines.core)
}