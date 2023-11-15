package ru.glebik.feature.home.api.usecase

import ru.glebik.feature.home.api.service.response.animefull.AnimeFullResponse
import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchResponse

interface GetAnimeFullUseCase {
    suspend operator fun invoke(id : Int): AnimeFullResponse
}