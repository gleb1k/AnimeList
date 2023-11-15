package ru.glebik.feature.home.api.repository

import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchData

interface HomeRepository {
    //todo response to data model
    suspend fun searchAnime(q: String): List<AnimeSearchData>
}