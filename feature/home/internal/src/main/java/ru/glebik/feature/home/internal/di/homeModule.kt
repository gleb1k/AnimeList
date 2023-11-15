package ru.glebik.feature.home.internal.di

import org.koin.dsl.module
import ru.glebik.feature.home.api.repository.HomeRepository
import ru.glebik.feature.home.api.service.AnimeService
import ru.glebik.feature.home.api.usecase.SearchAnimeUseCase
import ru.glebik.feature.home.internal.data.AnimeServiceImpl
import ru.glebik.feature.home.internal.data.HomeRepositoryImpl
import ru.glebik.feature.home.internal.domain.usecase.SearchAnimeUseCaseImpl

val homeModule = module {
    single<AnimeService> {
        AnimeServiceImpl(get())
    }
    factory<HomeRepository> {
        HomeRepositoryImpl(get())
    }
    factory<SearchAnimeUseCase> {
        SearchAnimeUseCaseImpl(get())
    }
}