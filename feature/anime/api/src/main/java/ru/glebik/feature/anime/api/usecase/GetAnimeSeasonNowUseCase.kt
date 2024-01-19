package ru.glebik.feature.anime.api.usecase

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel

interface GetAnimeSeasonNowUseCase {
    suspend operator fun invoke(): ResultWrapper<List<AnimeBaseModel>>
}