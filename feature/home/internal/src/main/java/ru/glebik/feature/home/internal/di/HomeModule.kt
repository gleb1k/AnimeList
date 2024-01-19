package ru.glebik.feature.home.internal.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.feature.home.internal.presentation.HomeScreen
import ru.glebik.feature.home.internal.presentation.viewmodel.HomeScreenModel
import ru.glebik.feature.home.internal.presentation.viewmodel.HomeStore
import ru.glebik.feature.home.internal.presentation.viewmodel.HomeStoreFactory

val homeModule = module {

    factory<HomeStore> {
        HomeStoreFactory(
            storeFactory = get(),
            getAnimeRecommendationsUseCase = get(),
            getAnimeSeasonNowUseCase = get(),
            getTopAnimeByScoreUseCase = get()
        ).create()
    }

    factory<HomeScreenModel> { HomeScreenModel(get()) }
}

val homeScreenModule = screenModule {
    register<SharedScreen.Home> { HomeScreen }
}