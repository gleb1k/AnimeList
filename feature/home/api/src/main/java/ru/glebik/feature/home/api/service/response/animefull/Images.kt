package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Images(
    @SerialName("jpg")
    val jpg: ru.glebik.feature.home.api.service.response.animefull.Jpg?,
    @SerialName("webp")
    val webp: ru.glebik.feature.home.api.service.response.animefull.Webp?
)