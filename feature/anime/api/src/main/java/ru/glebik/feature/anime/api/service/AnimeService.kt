package ru.glebik.feature.anime.api.service

import ru.glebik.feature.anime.api.model.response.animefull.AnimeFullResponse
import ru.glebik.feature.anime.api.model.response.base.AnimeBaseResponse
import ru.glebik.feature.anime.api.model.response.recommendations.AnimeRecommendationsResponse

interface AnimeService {

    suspend fun getAnimeFull(id: Int): AnimeFullResponse

    suspend fun getAnimeRecommendations(id: Int): AnimeRecommendationsResponse

    suspend fun searchAnime(q: String): AnimeBaseResponse

    suspend fun getSeasonsNow(): AnimeBaseResponse

    suspend fun getTopAnime(filter: String?): AnimeBaseResponse
}