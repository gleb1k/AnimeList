package ru.glebik.feature.anime.api.usecase

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeFull

interface GetAnimeFullUseCase {
    suspend operator fun invoke(id: Int): ResultWrapper<AnimeFull>
}