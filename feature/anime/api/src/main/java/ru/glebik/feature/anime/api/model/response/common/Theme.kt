package ru.glebik.feature.anime.api.model.response.common


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Theme(
    @SerialName("mal_id")
    val malId: Int?,
    @SerialName("type")
    val type: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)