package ru.glebik.feature.anime.api.usecase

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeSearch

interface SearchAnimeUseCase {

    suspend operator fun invoke(q: String): ResultWrapper<List<AnimeSearch>>
}