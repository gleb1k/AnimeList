package ru.glebik.feature.anime.api.repository

import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeFull
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.anime.api.model.domain.AnimeSearch

interface AnimeRepository {

    suspend fun searchAnime(q: String): ResultWrapper<List<AnimeSearch>>

    suspend fun getAnimeRecommendations(id: Int): ResultWrapper<List<AnimeRecommendation>>

    suspend fun getAnimeFull(id: Int): ResultWrapper<AnimeFull>
}