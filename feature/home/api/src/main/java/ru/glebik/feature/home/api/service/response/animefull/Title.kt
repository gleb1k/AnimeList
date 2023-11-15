package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Title(
    @SerialName("type")
    val type: String?,
    @SerialName("title")
    val title: String?
)