package ru.glebik.feature.anime.internal.domain

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.anime.api.repository.AnimeRepository
import ru.glebik.feature.anime.api.usecase.GetAnimeRecommendationsUseCase

internal class GetAnimeRecommendationsUseCaseImpl(
    private val repository: AnimeRepository,
) : GetAnimeRecommendationsUseCase {
    override suspend fun invoke(id: Int): ResultWrapper<List<AnimeRecommendation>> {
        return repository.getAnimeRecommendations(id)
    }
}