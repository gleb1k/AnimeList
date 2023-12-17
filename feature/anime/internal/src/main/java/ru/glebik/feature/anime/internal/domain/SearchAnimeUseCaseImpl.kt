package ru.glebik.feature.anime.internal.domain

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeSearch
import ru.glebik.feature.anime.api.repository.AnimeRepository
import ru.glebik.feature.anime.api.usecase.SearchAnimeUseCase

internal class SearchAnimeUseCaseImpl(
    private val repository: AnimeRepository,
) : SearchAnimeUseCase {
    override suspend fun invoke(q: String): ResultWrapper<List<AnimeSearch>> {
        return repository.searchAnime(q)
    }
}