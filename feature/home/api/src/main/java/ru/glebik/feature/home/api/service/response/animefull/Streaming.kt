package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Streaming(
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?
)