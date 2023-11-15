package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Prop(
    @SerialName("from")
    val from: ru.glebik.feature.home.api.service.response.animefull.From?,
    @SerialName("to")
    val to: ru.glebik.feature.home.api.service.response.animefull.To?
)