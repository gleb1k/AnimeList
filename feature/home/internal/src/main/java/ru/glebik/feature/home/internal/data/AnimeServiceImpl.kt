package ru.glebik.feature.home.internal.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.path
import ru.glebik.feature.home.api.service.AnimeService
import ru.glebik.feature.home.api.service.response.animefull.AnimeFullResponse
import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchResponse

internal class AnimeServiceImpl(
    private val client: HttpClient
) : AnimeService {
    override suspend fun searchAnime(q: String): AnimeSearchResponse {
        val temp : AnimeSearchResponse = client.get {
            url {
                path("/anime")
                parameter("q", q)
            }
        }.body()
        return temp
    }



    override suspend fun getAnimeFull(id: Int): AnimeFullResponse =
        client.get {
            url {
                path("/anime/${id}/full")
            }
        }.body()
}