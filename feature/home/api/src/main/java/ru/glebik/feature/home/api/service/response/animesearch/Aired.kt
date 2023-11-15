package ru.glebik.feature.home.api.service.response.animesearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Aired(
    @SerialName("from")
    val from: String?,
    @SerialName("to")
    val to: String?,
    @SerialName("prop")
    val prop: ru.glebik.feature.home.api.service.response.animesearch.Prop?,
    @SerialName("string")
    val string: String?
)