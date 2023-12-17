package ru.glebik.feature.auth.internal.di

import cafe.adriel.voyager.core.registry.screenModule
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.feature.auth.internal.presentation.SignInScreen
import ru.glebik.feature.auth.internal.presentation.SignUpScreen

val authScreenModule = screenModule {
    register<SharedScreen.SignIn> { SignInScreen }
    register<SharedScreen.SignUp> { SignUpScreen }
}