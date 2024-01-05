package ru.glebik.feature.detail.internal.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.core.widget.template.DetailScreenModel
import ru.glebik.feature.detail.internal.presentation.DetailScreen
import ru.glebik.feature.detail.internal.presentation.viewmodel.DetailStore
import ru.glebik.feature.detail.internal.presentation.viewmodel.DetailStoreFactory

val detailModule = module {
    factory<DetailStore> {
        DetailStoreFactory(
            storeFactory = get(),
            getAnimeFullUseCase = get(),
        ).create()
    }

    factory<DetailScreenModel> { DetailScreenModel(get()) }
}

val detailScreenModule = screenModule {
    register<SharedScreen.Detail> { DetailScreen(it.id) }
}