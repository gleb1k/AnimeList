package ru.glebik.feature.anime.api.model.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class External(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)