package ru.glebik.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

// Здесь будут лежать все экраны приложения
sealed class SharedScreen : ScreenProvider {
    data object Home : SharedScreen()
    data class Detail(val id: Int) : SharedScreen()
    data object Search : SharedScreen()

    data object Profile : SharedScreen()

    data object SignIn : SharedScreen()
    data object SignUp : SharedScreen()
}