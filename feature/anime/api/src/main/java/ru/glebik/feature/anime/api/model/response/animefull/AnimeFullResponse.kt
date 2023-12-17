package ru.glebik.feature.anime.api.model.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AnimeFullResponse(
    @SerialName("data")
    val animeFullData: AnimeFullData?
)