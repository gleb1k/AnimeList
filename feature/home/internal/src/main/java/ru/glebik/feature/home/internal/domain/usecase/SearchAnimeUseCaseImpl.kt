package ru.glebik.feature.home.internal.domain.usecase

import ru.glebik.feature.home.api.repository.HomeRepository
import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchData
import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchResponse
import ru.glebik.feature.home.api.usecase.SearchAnimeUseCase

internal class SearchAnimeUseCaseImpl(
    private val homeRepository: HomeRepository
) : SearchAnimeUseCase {
    override suspend fun invoke(q : String): List<AnimeSearchData> =
        homeRepository.searchAnime(q)

}