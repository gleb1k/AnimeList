package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeFullResponse(
    @SerialName("data")
    val animeFullData: ru.glebik.feature.home.api.service.response.animefull.AnimeFullData?
)