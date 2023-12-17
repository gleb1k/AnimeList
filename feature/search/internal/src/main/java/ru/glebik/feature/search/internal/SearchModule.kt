package ru.glebik.feature.search.internal

import cafe.adriel.voyager.core.registry.screenModule
import ru.glebik.core.navigation.SharedScreen

val searchScreenModule = screenModule {
    register<SharedScreen.Search> { SearchScreen }
}