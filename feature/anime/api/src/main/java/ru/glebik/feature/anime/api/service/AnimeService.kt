package ru.glebik.feature.anime.api.service

import ru.glebik.feature.anime.api.model.response.animefull.AnimeFullResponse
import ru.glebik.feature.anime.api.model.response.animesearch.AnimeSearchResponse
import ru.glebik.feature.anime.api.model.response.recommendations.AnimeRecommendationsResponse

interface AnimeService {

    suspend fun searchAnime(q: String): AnimeSearchResponse

    suspend fun getAnimeFull(id: Int): AnimeFullResponse

    suspend fun getAnimeRecommendations(id: Int): AnimeRecommendationsResponse
}