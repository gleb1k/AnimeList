package ru.glebik.feature.home.api.service

import ru.glebik.feature.home.api.service.response.animefull.AnimeFullData
import ru.glebik.feature.home.api.service.response.animefull.AnimeFullResponse
import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchResponse

interface AnimeService {

    suspend fun searchAnime(q : String) : AnimeSearchResponse

    suspend fun getAnimeFull (id : Int) : AnimeFullResponse
}