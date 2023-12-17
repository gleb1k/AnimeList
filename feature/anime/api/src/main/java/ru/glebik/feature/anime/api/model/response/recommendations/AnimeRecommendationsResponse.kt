package ru.glebik.feature.anime.api.model.response.recommendations


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeRecommendationsResponse(
    @SerialName("data")
    val recommendationsList: List<AnimeRecommendationResponseItem>?
)