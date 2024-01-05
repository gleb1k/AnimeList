plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "ru.glebik.feature.detail.internal"
    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeKotlinCompiler.get()
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
}

dependencies {

    implementation(project(":feature:anime:api"))
    implementation(project(":feature:detail:api"))

    implementation(project(":core:presentation"))
    implementation(project(":core:widget"))
    implementation(project(":core:utils"))
    implementation(project(":core:db"))
    implementation(project(":core:network"))
    implementation(project(":core:navigation"))

    implementation(libs.koin)
    implementation(libs.koin.compose)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}