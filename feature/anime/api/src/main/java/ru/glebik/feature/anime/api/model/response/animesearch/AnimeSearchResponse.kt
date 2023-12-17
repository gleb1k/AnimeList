package ru.glebik.feature.anime.api.model.response.animesearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeSearchResponse(
    @SerialName("pagination")
    val pagination: Pagination?,
    @SerialName("data")
    val searchList: List<AnimeSearchResponseItem>?
)