package ru.glebik.feature.anime.internal.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import ru.glebik.feature.anime.api.model.response.animefull.AnimeFullResponse
import ru.glebik.feature.anime.api.model.response.base.AnimeBaseResponse
import ru.glebik.feature.anime.api.model.response.recommendations.AnimeRecommendationsResponse
import ru.glebik.feature.anime.api.service.AnimeService

internal class AnimeServiceImpl(
    private val client: HttpClient
) : AnimeService {
    override suspend fun searchAnime(q: String): AnimeBaseResponse {
        val temp: AnimeBaseResponse = client.get {
            url {
                path("/anime")
                parameter("q", q)
            }
        }.body()
        return temp
    }

    override suspend fun getSeasonsNow(): AnimeBaseResponse = client.get {
        url {
            path("/seasons/now")
        }
    }.body()


    override suspend fun getTopAnime(filter: String?): AnimeBaseResponse = client.get {
        url {
            path("/top/anime")
            parameter("filter", filter)
        }
    }.body()

    override suspend fun getAnimeFull(id: Int): AnimeFullResponse =
        client.get {
            url {
                path("/anime/${id}/full")
            }
        }.body()

    override suspend fun getAnimeRecommendations(id: Int): AnimeRecommendationsResponse =
        client.get {
            url {
                path("/anime/${id}/recommendations")
            }
        }.body()

}