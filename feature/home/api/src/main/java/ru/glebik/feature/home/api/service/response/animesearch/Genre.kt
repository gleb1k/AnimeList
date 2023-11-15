package ru.glebik.feature.home.api.service.response.animesearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Genre(
    @SerialName("mal_id")
    val malId: Int?,
    @SerialName("type")
    val type: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)