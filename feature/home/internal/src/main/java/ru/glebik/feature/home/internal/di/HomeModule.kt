package ru.glebik.feature.home.internal.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.feature.home.internal.presentation.ui.HomeScreen
import ru.glebik.feature.home.internal.presentation.viewmodel.HomeStore
import ru.glebik.feature.home.internal.presentation.viewmodel.HomeStoreFactory
import ru.glebik.feature.home.internal.presentation.viewmodel.MviHomeScreenModel

val homeModule = module {

    factory<HomeStore> {
        HomeStoreFactory(
            storeFactory = get(),
            getAnimeRecommendationsUseCase = get(),
        ).create()
    }

    factory<MviHomeScreenModel> { MviHomeScreenModel(get()) }
}

val homeScreenModule = screenModule {
    register<SharedScreen.Home> { HomeScreen }
}