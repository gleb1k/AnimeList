package ru.glebik.feature.anime.api.repository

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.api.model.domain.AnimeFull
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation

interface AnimeRepository {

    suspend fun getAnimeRecommendations(id: Int): ResultWrapper<List<AnimeRecommendation>>

    suspend fun getAnimeFull(id: Int): ResultWrapper<AnimeFull>

    suspend fun searchAnime(q: String): ResultWrapper<List<AnimeBaseModel>>

    suspend fun getSeasonsNow(): ResultWrapper<List<AnimeBaseModel>>

    suspend fun getTopAnime(filter: String?): ResultWrapper<List<AnimeBaseModel>>
}