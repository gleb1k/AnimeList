package ru.glebik.feature.anime.internal.domain

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeFull
import ru.glebik.feature.anime.api.repository.AnimeRepository
import ru.glebik.feature.anime.api.usecase.GetAnimeFullUseCase

internal class GetAnimeFullUseCaseImpl(
    private val repository: AnimeRepository,
) : GetAnimeFullUseCase {
    override suspend fun invoke(id: Int): ResultWrapper<AnimeFull> {
        return repository.getAnimeFull(id)
    }
}