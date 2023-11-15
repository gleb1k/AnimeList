package ru.glebik.feature.home.api.service.response.animesearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeSearchResponse(
    @SerialName("pagination")
    val pagination: ru.glebik.feature.home.api.service.response.animesearch.Pagination?,
    @SerialName("data")
    val animeSearchData: List<ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchData>?
)