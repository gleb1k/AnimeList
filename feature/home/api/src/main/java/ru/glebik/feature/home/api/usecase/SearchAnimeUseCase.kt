package ru.glebik.feature.home.api.usecase

import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchData
import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchResponse

interface SearchAnimeUseCase {

    suspend operator fun invoke(q: String): List<AnimeSearchData>
}