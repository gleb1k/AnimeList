package ru.glebik.feature.search.internal.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.core.utils.CoroutineDispatchers
import ru.glebik.feature.search.internal.presentation.SearchScreen
import ru.glebik.feature.search.internal.presentation.viewmodel.SearchScreenModel
import ru.glebik.feature.search.internal.presentation.viewmodel.SearchStore
import ru.glebik.feature.search.internal.presentation.viewmodel.SearchStoreFactory

val searchScreenModule = screenModule {
    register<SharedScreen.Search> { SearchScreen }
}

val searchModule = module {
    factory<SearchStore> {
        SearchStoreFactory(
            storeFactory = get(),
            searchAnimeUseCase = get(
            ),
            ioDispatcher = get(named(CoroutineDispatchers.IO))
        ).create()
    }

    factory<SearchScreenModel> { SearchScreenModel(get()) }
}
