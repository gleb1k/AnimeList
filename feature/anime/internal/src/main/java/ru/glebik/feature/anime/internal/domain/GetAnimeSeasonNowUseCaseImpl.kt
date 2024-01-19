package ru.glebik.feature.anime.internal.domain

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.api.repository.AnimeRepository
import ru.glebik.feature.anime.api.usecase.GetAnimeSeasonNowUseCase

internal class GetAnimeSeasonNowUseCaseImpl(
    private val repository: AnimeRepository,
) : GetAnimeSeasonNowUseCase {
    override suspend fun invoke(): ResultWrapper<List<AnimeBaseModel>> {
        return repository.getSeasonsNow()
    }
}