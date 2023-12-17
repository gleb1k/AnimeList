package ru.glebik.feature.anime.api.model.response.recommendations


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeRecommendationResponseItem(
    @SerialName("entry")
    val entry: EntryRecommendations,
    @SerialName("url")
    val url: String?,
    @SerialName("votes")
    val votes: Int?
)