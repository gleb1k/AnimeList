package ru.glebik.feature.anime.internal.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.core.utils.mapper.ResponseDomainMapper
import ru.glebik.feature.anime.api.model.domain.AnimeFull
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.anime.api.model.domain.AnimeSearch
import ru.glebik.feature.anime.api.model.response.animefull.AnimeFullResponse
import ru.glebik.feature.anime.api.model.response.animesearch.AnimeSearchResponseItem
import ru.glebik.feature.anime.api.model.response.recommendations.AnimeRecommendationResponseItem
import ru.glebik.feature.anime.api.repository.AnimeRepository
import ru.glebik.feature.anime.api.service.AnimeService

internal class AnimeRepositoryImpl(
    private val animeService: AnimeService,
    private val ioDispatcher: CoroutineDispatcher,

    private val animeFullResponseMapper: ResponseDomainMapper<AnimeFullResponse, AnimeFull>,
    private val animeSearchResponseMapper: ResponseDomainMapper<AnimeSearchResponseItem, AnimeSearch>,
    private val animeRecommendationResponseMapper: ResponseDomainMapper<AnimeRecommendationResponseItem, AnimeRecommendation>
) : AnimeRepository {

    override suspend fun searchAnime(q: String): ResultWrapper<List<AnimeSearch>> =
        withContext(ioDispatcher) {
            runCatching {
                animeService.searchAnime(q)
            }.fold(
                onSuccess = {
                    val resultList = it.searchList?.map { anime ->
                        animeSearchResponseMapper.toDomain(anime)
                    } ?: listOf()
                    ResultWrapper.Success(resultList)
                },
                onFailure = {
                    ResultWrapper.Failed(it, it.message)
                }
            )
        }

    override suspend fun getAnimeRecommendations(id: Int): ResultWrapper<List<AnimeRecommendation>> =
        withContext(ioDispatcher) {
            runCatching {
                animeService.getAnimeRecommendations(id)
            }.fold(
                onSuccess = {
                    val resultList = it.recommendationsList?.map { anime ->
                        animeRecommendationResponseMapper.toDomain(anime)
                    } ?: listOf()

                    ResultWrapper.Success(resultList)
                },
                onFailure = { ResultWrapper.Failed(it, it.message) }
            )
        }

    override suspend fun getAnimeFull(id: Int): ResultWrapper<AnimeFull> =
        withContext(ioDispatcher) {
            runCatching {
                animeService.getAnimeFull(id)
            }.fold(
                onSuccess = { ResultWrapper.Success(animeFullResponseMapper.toDomain(it)) },
                onFailure = { ResultWrapper.Failed(it, it.message) }
            )
        }
}