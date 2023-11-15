package ru.glebik.feature.home.api.service.response.animesearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Images(
    @SerialName("jpg")
    val jpg: ru.glebik.feature.home.api.service.response.animesearch.Jpg?,
    @SerialName("webp")
    val webp: ru.glebik.feature.home.api.service.response.animesearch.Webp?
)