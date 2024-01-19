package ru.glebik.feature.anime.internal.domain

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.api.repository.AnimeRepository
import ru.glebik.feature.anime.api.usecase.GetTopAnimeByScoreUseCase

internal class GetTopAnimeByScoreUseCaseImpl(
    private val repository: AnimeRepository,
) : GetTopAnimeByScoreUseCase {
    override suspend fun invoke(): ResultWrapper<List<AnimeBaseModel>> {
        return repository.getTopAnime(null)
    }
}