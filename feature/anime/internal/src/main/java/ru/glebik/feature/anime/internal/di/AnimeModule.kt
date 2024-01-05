package ru.glebik.feature.anime.internal.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.glebik.core.utils.CoroutineDispatchers
import ru.glebik.core.utils.mapper.ResponseMapper
import ru.glebik.feature.anime.api.model.domain.AnimeFull
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.anime.api.model.domain.AnimeSearch
import ru.glebik.feature.anime.api.model.response.animefull.AnimeFullResponse
import ru.glebik.feature.anime.api.model.response.animesearch.AnimeSearchResponseItem
import ru.glebik.feature.anime.api.model.response.recommendations.AnimeRecommendationResponseItem
import ru.glebik.feature.anime.api.repository.AnimeRepository
import ru.glebik.feature.anime.api.service.AnimeService
import ru.glebik.feature.anime.api.usecase.GetAnimeFullUseCase
import ru.glebik.feature.anime.api.usecase.GetAnimeRecommendationsUseCase
import ru.glebik.feature.anime.api.usecase.SearchAnimeUseCase
import ru.glebik.feature.anime.internal.data.AnimeRepositoryImpl
import ru.glebik.feature.anime.internal.data.AnimeServiceImpl
import ru.glebik.feature.anime.internal.data.mapper.AnimeFullResponseMapper
import ru.glebik.feature.anime.internal.data.mapper.AnimeRecommendationResponseMapper
import ru.glebik.feature.anime.internal.data.mapper.AnimeSearchResponseMapper
import ru.glebik.feature.anime.internal.domain.GetAnimeFullUseCaseImpl
import ru.glebik.feature.anime.internal.domain.GetAnimeRecommendationsUseCaseImpl
import ru.glebik.feature.anime.internal.domain.SearchAnimeUseCaseImpl

val animeModule = module {
    single<ResponseMapper<AnimeFullResponse, AnimeFull>>(named(AnimeFullResponseMapper.TAG)) {
        AnimeFullResponseMapper()
    }
    single<ResponseMapper<AnimeRecommendationResponseItem, AnimeRecommendation>>(
        named(AnimeRecommendationResponseMapper.TAG)
    ) { AnimeRecommendationResponseMapper() }
    single<ResponseMapper<AnimeSearchResponseItem, AnimeSearch>>(
        named(AnimeSearchResponseMapper.TAG)
    ) {
        AnimeSearchResponseMapper()
    }

    single<AnimeService> {
        AnimeServiceImpl(get())
    }
    factory<AnimeRepository> {
        AnimeRepositoryImpl(
            animeService = get(), ioDispatcher = get(named(CoroutineDispatchers.IO)),
            animeFullResponseMapper = get(named(AnimeFullResponseMapper.TAG)),
            animeSearchResponseMapper = get(named(AnimeSearchResponseMapper.TAG)),
            animeRecommendationResponseMapper = get(named(AnimeRecommendationResponseMapper.TAG)),
        )
    }
    factory<SearchAnimeUseCase> {
        SearchAnimeUseCaseImpl(get())
    }
    factory<GetAnimeFullUseCase> {
        GetAnimeFullUseCaseImpl(get())
    }
    factory<GetAnimeRecommendationsUseCase> {
        GetAnimeRecommendationsUseCaseImpl(get())
    }
}