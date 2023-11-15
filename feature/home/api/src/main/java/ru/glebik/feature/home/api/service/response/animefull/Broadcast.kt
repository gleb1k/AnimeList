package ru.glebik.feature.home.api.service.response.animefull


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Broadcast(
    @SerialName("day")
    val day: String?,
    @SerialName("time")
    val time: String?,
    @SerialName("timezone")
    val timezone: String?,
    @SerialName("string")
    val string: String?
)