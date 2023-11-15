package ru.glebik.feature.home.api.service.response.animesearch


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Items(
    @SerialName("count")
    val count: Int?,
    @SerialName("total")
    val total: Int?,
    @SerialName("per_page")
    val perPage: Int?
)