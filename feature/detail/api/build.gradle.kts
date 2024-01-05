plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "ru.glebik.feature.detail.api"
    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    implementation(project(":feature:anime:api"))

    api(project(":core:widget"))
    api(project(":core:utils"))
    api(project(":core:db"))
    api(project(":core:network"))
    api(project(":core:navigation"))
    api(project(":core:presentation"))

    api(libs.koin)
    api(libs.koin.compose)

    api(libs.kotlinx.serialization.json)
    api(libs.ktor.serialization)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}