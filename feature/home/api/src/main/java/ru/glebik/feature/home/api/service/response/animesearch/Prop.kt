package ru.glebik.feature.home.api.service.response.animesearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Prop(
    @SerialName("from")
    val from: ru.glebik.feature.home.api.service.response.animesearch.From?,
    @SerialName("to")
    val to: ru.glebik.feature.home.api.service.response.animesearch.To?
)